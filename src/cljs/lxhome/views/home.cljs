(ns lxhome.views.home
  (:require [re-frame.core :as re-frame]))
;; home

(defn home-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:header {:class :header} (str "Hello from " @name ". This is the Home Page.")
       [:div [:a {:href "#/about"} "go to About Page"]]])))
