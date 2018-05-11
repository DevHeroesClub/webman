(ns webman.views.footer)


(defn bar
  []
  [:footer {:className "footer"}
   [:div {:className :container}
    [:div {:className "content has-text-centered"}
     [:p
      [:strong "SITE_TITLE"]
      " by "
      [:a {:href "//devheroes.club/"}
       "DevHeroees"]
      " community. The source code is licensed "
      [:a {:href "http://opensource.org/licenses/mit-license.php"} "MIT"]
      ". The website content is licensed "
      [:a {:href "http://creativecommons.org/licenses/by-nc-sa/4.0/"} "CC BY NC SA 4.0"]
      "."]]]])
