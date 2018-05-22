(ns webman.config
  (:require-macros [webman.website :refer [get-config]]))

(def debug?
  ^boolean goog.DEBUG)

(goog-define version "0.1.0")


(defn latest-posts-url
  []
  (str (get-config :api-base-url)
       (get-config :latest-posts-url)))
