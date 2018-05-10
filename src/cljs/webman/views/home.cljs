(ns webman.views.home
  (:require [re-frame.core :as re-frame]
            [webman.config :as config]))

(defn posts-list
  [posts]
  (doseq [post posts]
    [:h2 (:title post)]))
(defn index
  "Renders the home page"
  []
  (re-frame/dispatch [:fetch-posts])
  (let [posts (re-frame/subscribe [:posts])]
    [:div
     [:h1 "Posts"]
     [:article
      [posts-list @posts]]]))
