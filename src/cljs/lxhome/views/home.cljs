(ns lxhome.views.home
  (:require [re-frame.core :as re-frame]))

(goog-define version "0.1.0")

(defn menu-button
  []
  [:div {:class "button naked huge"
         :on-click #(re-frame/dispatch [:toggle-menu])}
   [:i {:class :icon-th}]])


(defn cv-button
  []
  [:section {:class :CV}
   [:a {:href "http://dl.lxsameer.com/CV/SameerRahmani.pdf" :class "button default large"}
    "Download My CV"]])


(defn menu-items
  []
  [:section {:class "row menu"}
;;   [:div {:class :menu}]
   [:span {:class :col-xs-4}
    [:a {:class "default button" :href "http://blog.lxsameer.com/"}
     [:i {:class :icon-rss}]
     "Blog"]]

   [:span {:class :col-xs-4}
    [:a {:class "default button" :href "https://slides.com/lxsameer"}
     [:i {:class :icon-chat}]
     "Talks"]]

   [:span {:class :col-xs-4}
    [:a {:class "default button" :href "#"}
     [:i {:class :icon-mic}]
     "Podcasts"]]

   [:span {:class :col-xs-4}
    [:a {:class "default button" :href "#"}
     [:i {:class :icon-key}]
     "GPG Key"]]

   [:span {:class :col-xs-4}
    [:a {:class "default button" :href "#"}
     [:i {:class :icon-phone}]
     "Contact"]]

   [:span {:class :col-xs-4}
    [:a {:class "default button" :href "#"}
     [:i {:class :icon-vcard}]
     "About Me"]]

   [:span {:class :col-xs-4}
    [:a {:class "default button" :href "#"}
     [:i {:class :icon-rss}]
     "Archive"]]

   [:span {:class :col-xs-4}
    [:a {:class "button default"
         :href "https://twitter.com/lxsameer"}
     [:i {:class :icon-twitter}]
     "Twitter"]]
   [:span {:class :col-xs-4}
    [:a {:class "button default"
         :href "https://github.com/lxsameer"}
     [:i {:class :icon-github}]
     "Github"]]
   [:span {:class :col-xs-4}
    [:a {:class "button default"
         :href "https://www.linkedin.com/in/lxsameer/"}
     [:i {:class :icon-linkedin}]
     "Linkedin"]]
   [:span {:class :col-xs-4}
    [:a {:class "button default"
         :href "https://medium.com/@lxsameer"}
     [:i {:class :icon-medium}]
     "Medium"]]
   [:span {:class :col-xs-4}
    [:a {:class "button default"
         :href "https://www.instagram.com/lxsameeer/"}
     [:i {:class :icon-instagram}]
     "Instagram"]]])


(defn name-and-title
  [menu]
  [:section {:class "title-header"}
   [:img {:src "images/me-1.jpg" :class :avatar :alt "Sameer Rahmani (@lxsameer) avatar"}]
   [:span {:class :no-wrap}
    [menu-button]
    [:span {:class "title"} "Sameer" [:span {:class "last-name"} "Rahmani"]]]
   [:h2 {:class "subtitle"} "Senior Software Engineer"]

   (if (not menu)
     [cv-button]
     [menu-items])
   [:span {:class :copyright} (str "© 2010-2017 Sameer Rahmani - " version)]])


(defn home-panel []
  (let [menu (re-frame/subscribe [:menu-state])]
    (fn []
      [:div {:class :container-fluid}
       [:section {:class "row middle-row middle-xs"}
        [:div {:class "col-xs-12 col-md-offset-2 col-md-8 col-lg-offset-4 col-lg-4"}
         [name-and-title @menu]]]])))
