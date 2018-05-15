(ns webman.website
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))


(defmacro get-config
  [key]
  (let [config-name (format "websites/%s.edn"
                            (or (System/getenv "WEBMAN_WEBSITE") "default"))

        resource (io/resource config-name)
        config (edn/read-string (slurp resource))]
    (get config key)))
