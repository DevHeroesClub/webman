(ns webman.views.iranclojure.navbar)
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