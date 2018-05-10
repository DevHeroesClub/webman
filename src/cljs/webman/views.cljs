(ns webman.views
  (:require
   [re-frame.core        :as re-frame]
   [webman.views.home    :as home]
   [webman.views.footer  :as footer]
   [webman.views.nav     :as nav]))

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home/index]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      [:div {:className "content"}
       [nav/bar]
       [show-panel @active-panel]
       [footer/bar]])))
