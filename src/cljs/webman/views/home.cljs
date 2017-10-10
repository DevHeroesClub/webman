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
;navbar using karajlug css
(defn navbar [] 
  [:div {} 
    [:header {:class "kl-header"}
      [:div {:class "container"}
        [:nav {:class "kl-navbar"} 
          [:ul {:class "kl-nav"}
            [:li 
              [:a {:href "http://google.com"} "صفحه اصلی"]
            ]
            [:li 
              [:a {:href "http://google.com"} "رویداد ها"]
            ]   
          ]
        ]
      ]
    ]
  ]
)
