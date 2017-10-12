(ns webman.views.iranclojure.posts)
(defn iranclojure-posts [posts] 
    [:main 
      [:div {:class "container"}
        [:article {:class "post-content"} 
          [:ul {:class "list-post"}    
            (for [post posts]  
              [:li {:class "post"}
                [:a {:class "post" :href (:link post)} (:title post)]
                [:p (:summary post)]])]]]])