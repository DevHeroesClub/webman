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
  [:nav {:className "navbar is-success is-fixed-top is-spaced"}
   [:div {:className "container"}

    ;; TODO: Add logo image in navbar-brand
    [:div {:className :navbar-brand}]

    [:div {:className "navbar-end"}
     [:a {:href "/"
          :className "navbar-item"}
      [:span
       (get-config :title)]]

     (for [item left-side-menu-items]
       ^{:key item}

       [:a {:className (:class item)
            :href      (:href item)}
        [:span
         (when (:icon item)
           [:i {:className (:icon item)}])
         (t (:name item))]])]


    [:div {:className "navbar-start"}
     (for [item right-side-menu-items]
       ^{:key item}
       [:a {:className  (str "navbar-item " (:class item))
            :href       (:href item)}
        (when (:icon item)
          [:i {:className (:icon item)}])
        (t (:name item))])]]])
