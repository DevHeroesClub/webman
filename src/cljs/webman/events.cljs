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
                  :uri             "https://devheroes.club/c/general.json"
                  :params          {:api_key "4b971bf2488e0901402faa2dc238e1a42c0eac4aa6e28108114823273929eeea"
                                    :api_username "webman"
                                    :page 1}
                  :timeout         8000
                  :response-format (ajax/json-response-format {:keywords? true})
                  :on-success      [:populate-topics]
                  :on-failure      [:failed-to-fetch]}}))

(re-frame/reg-event-db
 :populate-topics
 (fn [db [_ topics]]
   (assoc db
          :topics  (:topics (:topic_list (js->clj topics)))
          :loading false)))

(re-frame/reg-event-db
 :failed-to-fetch
 (fn [db [_ errors]]
   (assoc db :errors errors)))
