(ns webman.views
  (:require [re-frame.core :as re-frame]
            [webman.views.home :as home]
            [webman.views.navbar :as navbar]
            [webman.views.footer :as footer]
            [webman.views.posts :as posts]))

(defn home-panel
  []
  (home/home-panel))
(defn show-navbar []
  (navbar/show))
(defn show-footer []
  (footer/show)
  )
(defn show-posts []
  ;should get new posts about clojure from dev heroes
  (posts/show [{:link "" :title "شروع" :summary "شروع با clojure"}])
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
