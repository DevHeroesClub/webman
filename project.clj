(defproject webman "0.3.1"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [reagent               "0.8.1"]
                 [re-frame              "0.10.5"]
                 [day8.re-frame/http-fx "0.1.6"]
                 [com.taoensso/tempura  "1.2.1"]
                 [secretary             "1.2.3"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-shell "0.5.0"]
            [lein-less "1.7.5"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"
                                    "test/js"]

  :figwheel {:css-dirs ["resources/public/css"]}

  :less {:source-paths ["less"]
         :target-path  "resources/public/css"}

  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools      "0.9.10"]
                   [re-frisk                "0.5.4"]
                   [figwheel-sidecar        "0.5.16"]
                   [day8.re-frame/re-frame-10x "0.3.3"]
                   [com.cemerick/piggieback "0.2.2"]]

    :plugins      [[lein-figwheel "0.5.16"]
                   [lein-doo "0.1.7"]]}}


  :aliases {"sass" ["shell" "sass" "--watch" "-Isass/" "--sourcemap=file"
                    ~(clojure.core/format "sass/%s.sass:resources/public/css/web.css"
                                          (or (System/getenv "WEBMAN_WEBSITE")
                                              "web"))]
            "sass-compile" ["shell" "sass" "-t compressed" ~(clojure.core/format "sass/%s.sass:resources/public/css/web.css"
                                                                                 (or (System/getenv "WEBMAN_WEBSITE")
                                                                                     "web"))]}


  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]

     :figwheel     {:on-jsload "webman.core/mount-root"}

     :compiler     {:main                 webman.core
                    :preloads             [devtools.preload
                                           re-frisk.preload
                                           day8.re-frame-10x.preload]
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true

                    :closure-defines {goog.DEBUG                            true
                                      "re_frame.trace.trace_enabled_QMARK_" true
                                      "webman.views.home.version"           "dev"}

                    :external-config      {:devtools/config {:features-to-install :all}}}}


    {:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main            webman.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false
                                      "webman.views.home.version" "0.3.1"}
                    :pretty-print    false}}

    {:id           "test"
     :source-paths ["src/cljs" "test/cljs"]
     :compiler     {:main          webman.runner
                    :output-to     "resources/public/js/compiled/test.js"
                    :output-dir    "resources/public/js/compiled/test/out"
                    :optimizations :none}}]})
