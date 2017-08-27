(ns lxhome.views.home
  (:require [re-frame.core :as re-frame]))
;; home

(defn menu-button
  []
  [:div {:class "button naked large"
         :on-click #(js/alert "asd")}
   [:i {:class :icon-th}]])

(defn nav-header
  []
  [:header {:class :header}
   [menu-button]])

(defn cv-button
  []
  [:section {:class :CV}
   [:a {:href "dl.lxsameer.com/SameerRahmani.pdf" :class "button default large"}
    "Download My CV"]])


(defn social-links
  []
  [:nav {:class :social}
   [:ul
    [:li [:a {:class "button default small circle" :href "https://twitter.com/lxsamer"} [:i {:class :icon-twitter}]]]
    [:li [:a {:class "button default small circle" :href "https://github.com/lxsamer"} [:i {:class :icon-github}]]]
    [:li [:a {:class "button default small circle" :href "https://www.reddit.com/user/lxsameer/"} [:i {:class :icon-reddit-alien}]]]
    [:li [:a {:class "button default small circle" :href "https://www.linkedin.com/in/lxsameer/"} [:i {:class :icon-linkedin}]]]
    [:li [:a {:class "button default small circle" :href "https://medium.com/@lxsamer"} [:i {:class :icon-medium}]]]
    [:li [:a {:class "button default small circle" :href "https://www.instagram.com/lxsameeer/"} [:i {:class :icon-instagram}]]]]])




(defn home-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div

       [nav-header]
       [:section {:class :content}
        [:div {:class :waste}]
        [:section {:class :main-content}
         [:section {:class "title-header"}
          [:img {:src "images/me-1.jpg" :class :avatar :alt "Sameer Rahmani (@lxsameer) avatar"}]
          [:h1 {:class "title"} "Sameer" [:span {:class "last-name"} "Rahmani"]]
          [:h2 {:class "subtitle"} "Senior Software Engineer"]
          [cv-button]]

         [social-links]]
        [:div {:class :waste}]]])))
