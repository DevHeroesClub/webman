(ns lxhome.views.home
  (:require [re-frame.core :as re-frame]))
;; home

(defn menu-button
  []
  [:div {:class "button naked large"
         :on-click #(re-frame/dispatch [:toggle-menu])}
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


(defn name-and-title
  []
  [:section {:class "title-header"}
   [:img {:src "images/me-1.jpg" :class :avatar :alt "Sameer Rahmani (@lxsameer) avatar"}]
   [:h1 {:class "title"} "Sameer" [:span {:class "last-name"} "Rahmani"]]
   [:h2 {:class "subtitle"} "Senior Software Engineer"]
   [cv-button]])

(defn menu-items
  []
  [:section {:class :menu-items}
   [:ul {:class :menu}
    [:li
     [:a {:class "item" :href "#"}
      [:i {:class :icon-rss}]
      "Blog"]]

    [:li
     [:a {:class "item" :href "#"}
      [:i {:class :icon-mic}]
      "Slides"]]
    [:li
     [:a {:class "item" :href "#"}
      [:i {:class :icon-mic}]
      "Podcasts"]]

    [:li
     [:a {:class "item" :href "#"}
      [:i {:class :icon-key}]
      "GPG Public Key"]]

    [:li
     [:a {:class "item"
          :on-click #(re-frame/dispatch [:toggle-menu])}
      [:i {:class :icon-left-open-big}]
      "Back"]]]])

(defn home-panel []
  (let [menu (re-frame/subscribe [:menu-state])]
    (fn []
      [:div
       [nav-header]
       [:section {:class :content}
        [:div {:class :waste}]
        [:section {:class :main-content}
         (if (not @menu)
           [name-and-title]
           [menu-items])


         [social-links]]
        [:div {:class :waste}]]])))
