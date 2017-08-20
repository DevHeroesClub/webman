(ns lxhome.views.home
  (:require [re-frame.core :as re-frame]))
;; home

(defn menu-button
  []
  [:div {:class :menu-icon
         :on-click #(js/alert "asd")}
   "A"])

(defn nav-header
  []
  [:header {:class :header}
   [menu-button]])



(defn social-links
  []
  [:nav {:class :social}
   [:ul
    [:li [:a {:href "https://twitter.com/lxsamer"} "T"]]
    [:li [:a {:href "https://github.com/lxsamer"} "G"]]
    [:li [:a {:href "https://medium.com/lxsamer"} "M"]]]])




(defn home-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div

       [nav-header]
       [:section {:class :content}
        [:div {:class :waste}]
        [:section {:class :main-content}
         [:img {:src "images/me-1.jpg" :class :avatar :alt "Sameer Rahmani (@lxsameer) avatar"}]
         [:h1 {:class "title"} "Sameer Rahmani"]
         [:h2 {:class "subtitle"} "lxsameer"]
         [social-links]

         [:section {:class :CV}
          [:a {:href "dl.lxsameer.com/SameerRahmani.pdf" :class "button success large"}
           "Download My CV"]]]
        [:div {:class :waste}]]])))
