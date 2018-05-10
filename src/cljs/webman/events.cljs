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
  :fetch-posts
  (fn [{:keys [db]} _]
    {:db   (assoc db :loading true)
     :http-xhrio {:method          :get
                  :uri             "https://devheroes.club/latest.json?api_key=2d153df0001826d7920ad53f56f1ad0ffa0eae9fe3eb338e349b62f18825cc97"
                  :timeout         8000
                  :response-format (ajax/json-response-format {:keywords? true})
                  :on-success      [:populate-posts]
                  :on-failure      [:failed-to-fetch]}}))

(re-frame/reg-event-db
 :populate-posts
 (fn [db [_ posts]]
   (assoc db :posts posts)))

(re-frame/reg-event-db
 :failed-to-fetch
 (fn [db [_ errors]]
   (assoc db :errors errors)))
