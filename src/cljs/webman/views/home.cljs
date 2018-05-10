(ns webman.views.home
  (:require [re-frame.core :as re-frame]
            [webman.config :as config]))


(defn topic-list
  "Renders a list of topics"
  [topics]
  [:ul {:className "topic-list"}
   (for [topic topics]
     ^{:key topic}
     [:li {:className "topic"}
      [:h2 (:title topic)]])])


(defn index
  "Renders the home page"
  []
  (re-frame/dispatch [:fetch-topics])
  (let [topics   (re-frame/subscribe [:topics])]
    [:div
     [:h1 "Latest news"]
     [:article {:className "news"}
      [topic-list @topics]]]))
