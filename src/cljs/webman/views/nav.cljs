(ns webman.views.nav)

;; TODO: replace menu with a build time configuration.

(def menu-items
  [{:name "صفحه اصلی" :href "#"}])

(defn bar
  []
  [:nav {:className "navbar is-dark"
         :role "navigation"
         :aria-label "main navigation"}
   [:div {:className :navbar-brand}
    [:a {:href "#"
         :className "navbar-item"}
     "SITE_TITLE"]]
   [:div {:className "navbar-menu"}
    [:div {:className "navbar-end"}
     (for [item menu-items]
       ^{:key item}
       [:a {:className "navbar-item"
            :href (:href item)} (:name item)])]
    [:div {:className "navbar-start"}]]])
