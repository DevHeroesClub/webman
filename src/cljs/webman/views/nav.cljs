(ns webman.views.nav)

;; TODO: replace menu with a build time configuration.

(def menu-items
  [{:name "صفحه اصلی" :href "#"}])

(defn bar
  []
  [:nav {:className "navbar"}
   [:ul {:className "navbar-list"}
    (for [item menu-items]
      ^{:key item}
      [:li {:className "item"}
       [:a {:href (:href item)} (:name item)]])]])
