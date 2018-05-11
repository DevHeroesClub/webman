(ns webman.events
  (:require [re-frame.core :as re-frame]
            [ajax.core     :as ajax]
            [webman.db     :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
 :set-active-panel
 (fn [db [_ active-panel]]
   (assoc db :active-panel active-panel)))

(re-frame/reg-event-fx
  :fetch-topics
  (fn [{:keys [db]} _]
    {:db   (assoc db :loading true)
     :http-xhrio {:method          :get
                  :uri             "https://devheroes.club/c/offtopic/l/latest.json"
                  :params          {:api_key "4b971bf2488e0901402faa2dc238e1a42c0eac4aa6e28108114823273929eeea"}

                  :timeout         8000
                  :response-format (ajax/json-response-format {:keywords? true})
                  :on-success      [:populate-topics]
                  :on-failure      [:failed-to-fetch]}}))

(defn  process-topic
  "Find the user details for the owner in the users list and
  embbed it in the topic map."
  [acc topic]
  (let [topics   (or (:topics acc) [])
        owner    (first (:posters topic))
        user     (first (filter #(= (:id %) (:user_id owner)) (:users acc)))]
    (assoc acc
           :topics
           (conj topics (assoc topic :user user)))))

(re-frame/reg-event-db
 :populate-topics
 (fn [db [_ result]]
   (let [topics (js->clj result)
         posts  (reduce process-topic
                        topics
                        (:topics (:topic_list topics)))]
     (assoc db
            :topics (:topics posts)
            :loading false))))

(re-frame/reg-event-db
 :failed-to-fetch
 (fn [db [_ errors]]
   (assoc db :errors errors)))
