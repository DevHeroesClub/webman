(ns webman.views.footer
  (:require
   [webman.i18n :refer [t]])

  (:require-macros
   [webman.website :refer [get-config]]))


(defn bar
  []
  [:footer {:className "footer"}
   [:div {:className :container}
    [:div {:className "content has-text-centered"}
     (if (get-config :footer)
       (get-config :footer)
       [:p
        [:strong (get-config :title)]
        (t  [:by " by "])
        [:a {:href "//devheroes.club/"}
         (t [:dev-heroes "DevHeroees"])]
        " community. The source code is licensed "
        [:a {:href "http://opensource.org/licenses/mit-license.php"} "MIT"]
        ". The website content is licensed "
        [:a {:href "http://creativecommons.org/licenses/by-nc-sa/4.0/"} "CC BY NC SA 4.0"]
        "."])]]])
