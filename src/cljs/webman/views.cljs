(ns webman.views
  (:require
   [re-frame.core        :as re-frame]
   [webman.views.home    :as home]
   [webman.views.footer  :as footer]
   [webman.i18n          :refer [t]]
   [webman.views.nav     :as nav])
  (:require-macros [webman.website :refer [get-config]]))


;; (defn- panels [panel-name]
;;   (for-current-website panel-name
;;                        :about [:h1 "about"]
;;                        [:div]))


(defn- panels [panel]
  (case panel
    :home-panel (get-config :home-fn)
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])


(defn hero
  []
  [:section {:className "hero is-medium is-success"}
   [:div {:className :hero-body}
    [:div {:className "container has-text-right"}
     [:img {:className :logo :src (get-config :logo)}]

     [:h2 {:className :title}
      (get-config :welcome-title)]
     [:p {:className :subtitle}
      (get-config :welcome-message)]]]])


(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      [:div
       [nav/bar]
       [hero]
       [:div {:className "container"}
        [show-panel @active-panel]]
       [footer/bar]])))
