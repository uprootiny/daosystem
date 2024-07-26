(ns hyperstition-goal-graph
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]))

(defn load-goal-graph [file-path]
  (with-open [rdr (io/reader file-path)]
    (edn/read (java.io.PushbackReader. rdr))))

(def goal-graph (load-goal-graph "goal-graph.edn"))

;; Check the loaded goal graph
(prn goal-graph)
