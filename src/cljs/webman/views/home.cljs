(ns webman.views.home
  (:require [re-frame.core :as re-frame]
            [webman.config :as config]))

(defn topic-list
  [topics]
  [:ul
   (for [topic topics]
     ^{:key topic}
     [:li
      [:h2 (:title topic)]])])

(defn index
  "Renders the home page"
  []
  (re-frame/dispatch [:fetch-topics])
  (let [topics (re-frame/subscribe [:topics])]
    [:div
     [:h1 "Posts"]
     [:article
      [topic-list @topics]]]))
