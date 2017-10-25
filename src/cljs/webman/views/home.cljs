(ns webman.views.home
  (:require [re-frame.core :as re-frame]
            [webman.config :as config]))

(defn home-panel []
  (let [menu (re-frame/subscribe [:menu-state])]
    (fn []
      [:div {:class :container-fluid}
       [:section {:class "row middle-row middle-xs"}
        [:div {:class "col-xs-12 col-md-offset-2 col-md-8 col-lg-offset-4 col-lg-4"}
         [:p @menu]
         [:h1 ]]]])))
	 
;;navbar using karajlug css
(defn iranclojure-navbar [] 
  [:div {} 
    [:header {:class "kl-header"}
      [:div {:class "container"}
        [:nav {:class "kl-navbar"} 
          [:ul {:class "kl-nav"}
            [:li 
              [:a {:href ""} "صفحه اصلی"]
            ]
            [:li 
              [:a {:href ""} "درباره ما"]
            ]
            [:li
              [:a {:href ""} "تماس با ما"]
            ]
            [:li
              [:a {:href ""} "مقالات"]
            ]
            [:li 
              [:a {:href ""} "میتینگ ها"]
            ]   
          ]
          [:div {:class "logo"}
            [:h2 {} "Clojure UserGroup"]
            [:img {:src "images/fav.svg" :width "80px" :height "80px"}]]]]]])
	    
;;posts will be vector of maps
(defn iranclojure-posts [posts] 
  [:main 
    [:div {:class "container"}
      [:article {:class "post-content"} 
        [:ul {:class "list-post"}    
          (for [post posts]  
            [:li {:class "post"}
              [:a {:class "post" :href (:link post)} (:title post)]
              [:p (:summary post)]])]]]])

(defn iranclojure-footer []
  [:footer {}
    [:section {:class "kl-sponsors"}
      [:h4 "حامیان ما"]
      [:ul {:class "sponsors"}
        [:li 
          [:a {:href ""} 
            [:img {:src "/images/me-1.jpg"}]
          ]
        ]
        [:li 
          [:a {:href ""} 
            [:img {:src "/images/me-1.jpg"}]]]]]])