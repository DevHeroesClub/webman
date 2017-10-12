(ns webman.views.footer)
(defn show []
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
