(ns webman.i18n
  (:require
   [taoensso.tempura :as tempura :refer [tr]]))

(def dictionary
  {:fa
   {:latest-news "آخرین اخبار"}})

;; TODO: Load the language from build configuration instead of hard coding
;;       it here.
(def t (partial tr {:dict dictionary} [:fa]))
