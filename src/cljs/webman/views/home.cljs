(ns webman.views.home
  (:require
   [re-frame.core :as re-frame]
   [webman.config :as config]
   [webman.i18n   :refer [t]]))

(def digits
  {"1" "۱" "2" "۲" "3" "۳" "4" "۴" "5" "۵" "6" "۶" "7" "۷" "8" "۸" "9" "۹" "0" "۰"})

(defn ->persian
  [number]
  (let [numstr (.toString number)]
    (clojure.string/join ""
                         (map #(or (get digits %) %) numstr))))

(defn render-topic
  [topic]
  (let [avatar-url (clojure.string/replace (:avatar_template (:user topic))
                                           "{size}"
                                           "45")
        avatar (str "https://devheroes.club" avatar-url)
        link (str "https://devheroes.club/t/"
                  (:slug topic)
                  "/"
                  (:id topic))]

    [:article {:className :media}
     [:div {:className :media-right}
      [:figure {:className "image is-45x45"}
       [:img {:alt "Image"
              :className "avatar"
              :src avatar}]]]

     [:div {:className "media-content has-text-right"}
      [:div {:className :content}
       [:a {:href link}
        [:h5 {:className "topic-name"} (:title topic)]]]

      [:nav {:className "level is-mobile"}
       [:div {:className :level-left}
        [:span {:className :level-item}
         (->persian (:views topic))]
        [:span {:className :level-item}
         (->persian (:created_at topic))]
        [:span {:className :level-item}
         (->persian (:like_count topic))]]]]]))

(defn topic-list
  "Renders a list of topics"
  [topics]
  [:div {:className "container"}
   (for [topic topics]
     ^{:key (:id topic)}
     [render-topic topic])])

(defn index
  "Renders the home page"
  []
  (re-frame/dispatch [:fetch-topics])
  (let [topics   (re-frame/subscribe [:topics])]
    [:section {:className "section"}
     [:div {:className "container"}
      [:div {:className "columns"}
       [:div {:className "column"}
        [:h1 {:className "title"} (t [:latest-news]) ":"]
        [:article {:className "news"}
         [topic-list @topics]]]]]]))
