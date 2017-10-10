(ns webman.views
  (:require [re-frame.core :as re-frame]
            [webman.views.home :as home]))

(defn home-panel
  []
  (home/home-panel))
(defn navbar []
  (home/navbar))
(defn footer []
  (home/footer)
  )
(defn posts []
  ;should get new posts about clojure from dev heroes

  (home/Posts [{:link "google.com" :title "TEST" :summary "test"}])
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
