(ns webman.core
  (:require
   [day8.re-frame.http-fx]
   [reagent.core :as reagent]
   [re-frame.core :as re-frame]
   [re-frisk.core :refer [enable-re-frisk!]]
   [webman.events]
   [webman.subs]
   [webman.routes :as routes]
   [webman.views :as views]
   [webman.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (enable-re-frisk!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))
