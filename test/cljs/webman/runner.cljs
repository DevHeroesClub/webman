(ns webman.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [webman.core-test]))

(doo-tests 'webman.core-test)
