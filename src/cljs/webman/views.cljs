(ns webman.views
  (:require [re-frame.core :as re-frame]
            [webman.views.home :as home]))

(defn home-panel
  []
  (home/home-panel))
(defn navbar []
  (home/iranclojure-navbar))
(defn footer []
  (home/iranclojure-footer)
  )
(defn posts []
  ;should get new posts about clojure from dev heroes

  (home/iranclojure-posts [{:link "" :title "شروع" :summary "شروع با clojure"}])
)
(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      [show-panel @active-panel])))
