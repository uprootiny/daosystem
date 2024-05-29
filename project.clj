(defproject cookbook "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/clojurescript "1.11.132"]
                 [re-frame "1.2.0"]
                 [reagent "1.1.0"]
                 [cljs-http "0.1.46"]
                 [day8.re-frame/http-fx "0.2.3"]]
  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.19"]]
  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]
  :cljsbuild {:builds {:dev {:source-paths ["src/cljs"]
                             :figwheel {:on-jsload "cookbook.core/mount-root"}
                             :compiler {:main cookbook.core
                                        :asset-path "js/out"
                                        :output-to "resources/public/js/app.js"
                                        :output-dir "resources/public/js/out"
                                        :source-map true
                                        :optimizations :none
                                        :pretty-print true}}
                      :prod {:source-paths ["src/cljs"]
                             :compiler {:main cookbook.core
                                        :output-to "resources/public/js/app.js"
                                        :optimizations :advanced
                                        :pretty-print false}}}}
  :profiles {:dev {:dependencies [[figwheel-sidecar "0.5.19"]
                                  [cider/piggieback "0.5.2"]]
                   :source-paths ["src/clj" "src/cljs"]
                   :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}}})
