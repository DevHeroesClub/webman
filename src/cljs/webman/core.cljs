(ns webman.core
  (:require [reagent.core :as reagent]
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
  (reagent/render [views/show-navbar]
                  (.getElementById js/document "nav"))
  (reagent/render [views/show-posts]
                  (.getElementById js/document "posts"))
  (reagent/render [views/show-footer]
                  (.getElementById js/document "footer")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))
