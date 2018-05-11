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


(defn hero
  []
  [:section {:className "hero is-medium is-info "}
   [:div {:className "hero-body"}
    [:div {:className "container"}
     [:p {:className :title} "SITE_TITLE"]
     [:p {:className :subtitle} "SITE_SUBTITLE"]]]])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      [:span
       [nav/bar]
       [hero]
       [:div {:className "container"}
        [show-panel @active-panel]]
       [footer/bar]])))
