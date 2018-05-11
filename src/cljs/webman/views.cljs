(ns webman.views
  (:require
   [re-frame.core        :as re-frame]
   [webman.views.home    :as home]
   [webman.views.footer  :as footer]
   [webman.i18n          :refer [t]]
   [webman.views.nav     :as nav]))

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home/index]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])


(defn hero
  []
  [:section {:className "hero is-medium is-success"}
   [:div {:className :hero-body}
    [:div {:className "container has-text-centered"}
     [:p {:className :title} "SITE_TITLE"]
     [:p {:className :subtitle} "SITE_SUBTITLE"]
     [:a {:className "button is-inverted  is-link is-outlined is-large" :href "#"}
      (t [:get_started "Get Started"])]]]])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      [:div
       [nav/bar]
       [hero]
       [:div {:className "container"}
        [show-panel @active-panel]]
       [footer/bar]])))
