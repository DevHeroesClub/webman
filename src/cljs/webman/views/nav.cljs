(ns webman.views.nav
  (:require
   [webman.i18n :refer [t]])
  (:require-macros
   [webman.website :refer [get-config]]))


(def left-side-menu-items
  "Returns a vector of hashmaps describing menu entries
  of the left side of navigation menu"
  (:left (get-config :navbar-menu)))

(def right-side-menu-items
  "Returns a vector of hashmaps describing menu entries
  of the left side of navigation menu"
  (:right (get-config :navbar-menu)))

(defn bar
  "Top navigation menu."
  []
  [:nav {:className "navbar is-success is-fixed-top"}
   [:div {:className :navbar-brand}
    [:a {:href "/"
         :className "navbar-item"}
     (get-config :title)]]

   [:div {:className "navbar-menu"}
    [:div {:className "navbar-end"}
     (for [item left-side-menu-items]
       ^{:key item}
       [:div {:className "navbar-item"}
        [:a {:className (:class item)
             :href      (:href item)}]
        (when (:icon item)
          [:i {:className (:icon item)}])
        (t (:name item))])]

    [:div {:className "navbar-start"}
     (for [item right-side-menu-items]
       ^{:key item}
       [:div {:className   "navbar-item"}
        [:a {:className  (str "navbar-item " (:class item))
             :href       (:href item)}
         (when (:icon item)
           [:i {:className (:icon item)}])
         (t (:name item))]])]]])
