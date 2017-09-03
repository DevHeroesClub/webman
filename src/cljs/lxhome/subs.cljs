(ns lxhome.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :menu-state
 (fn [db]
   (js/console.log "menu-state")
   (:menu-state db)))

(re-frame/reg-sub
 :active-panel
 (fn [db _]
   (js/console.log "active-panel")
   (:active-panel db)))
