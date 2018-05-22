(ns webman.website
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(defn asset
  "Reader function for `#asset` edn tag which append a random querystring
  to the assets url."
  [url]
  (format "%s?%s" url (int (* 100000000 (rand)))))

(def readers
  {'asset asset})

(defn website-name
  ([] (website-name "default"))
  ([default]
   (or (System/getenv "WEBMAN_WEBSITE") default)))


(defmacro get-config
  [key]
  (let [config-name (format "websites/%s.edn" (website-name))
        resource    (io/resource config-name)
        defaults    (edn/read-string {:readers readers}
                                     (slurp (io/resource "websites/default.edn")))
        config      (merge defaults (edn/read-string {:readers readers}
                                                     (slurp resource)))]

    (get config key)))

(defmacro require-index
  []
  (format "[webman.views.indexes.%s :as %s]" (website-name) "home"))

(defmacro current-index
  []
  (let [component (format "[webman.views.indexes.%s/index]" (website-name "default-website"))]
    `~component))

(defmacro for-current-website
  [panel & body]
  (let [component (format "[webman.views.indexes.%s/index]" (website-name "default-website"))]
    `(case ~panel
       :home-panel ~component
       ~@body)))
