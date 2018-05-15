(ns webman.views.nav
  (:require
   [webman.i18n :refer [t]])
  (:require-macros
   [webman.website :refer [get-config]]))

;; TODO: replace menu with a build time configuration.

(def menu-items
  [{:name (t [:home_page "Home"]) :href "#"}])

(defn bar
  []
  [:nav {:className "navbar is-success is-fixed-top"}
   [:div {:className :navbar-brand}
    [:a {:href "#"
         :className "navbar-item"}
     (get-config :title)]]
   [:div {:className "navbar-menu"}
    [:div {:className "navbar-end"}
     (for [item menu-items]
       ^{:key item}
       [:a {:className "navbar-item"
            :href (:href item)} (:name item)])]
    [:div {:className "navbar-start"}]]])
