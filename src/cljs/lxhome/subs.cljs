(ns lxhome.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :menu-state
 (fn [db]
   (:menu-state db)))

(re-frame/reg-sub
 :active-panel
 (fn [db _]
   (:active-panel db)))
