(ns webman.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :active-panel
 (fn [db _]
   (js/console.log "active-panel")
   (:active-panel db)))

(re-frame/reg-sub
 :topics
 (fn [db _]
   (:topics db)))
