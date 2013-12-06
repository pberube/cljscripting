(ns cljscripting.binary
  (:require [clojure.java.io :refer [file input-stream]]
            [cljscripting.util :as util]))

(def test-file "/home/pberube/work/test-data/ss-176/test1/Data20130510_1_frame.raw")

(defn add [x y]
  (+ x y))


(defn open [name-and-path]
  (try
    (input-stream (file name-and-path))
    (catch Throwable t
      nil)))


(defn read-bytes [file nb-bytes]
  (let [buffer (byte-array nb-bytes)]
    (.read file buffer)
    (vec buffer)))
