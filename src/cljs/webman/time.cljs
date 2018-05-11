(ns webman.time
  (:require))

(defn ->human
  [timestr]
  (first (clojure.string/split timestr "T")))
