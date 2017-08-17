(ns lxhome.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [lxhome.core-test]))

(doo-tests 'lxhome.core-test)
