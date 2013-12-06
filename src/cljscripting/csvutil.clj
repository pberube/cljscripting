(ns cljscripting.csvutil
 (:require [clojure-csv.core :as csv]
           [clojure.java.io :as io]))

(def rdr (io/reader "/home/pberube/work/fpga2/sdk/redcell_application_0/tests/events.csv"))

(def csv (csv/parse-csv rdr))


(defn average-column [column]
  (let [csv-col (get-column csv column 1)]
   (float (/ (reduce + csv-col) (count csv-col)))))


(defn column-count [column]
  (let [csv-col (get-column csv column 1)]
    (count csv-col)))


(defn column-max [column]
  (let [csv-col (get-column csv column 1)]
    (apply max csv-col)))


(defn column-min [column]
  (let [csv-col (get-column csv column 1)]
    (apply min csv-col)))


(defn get-column
  ([parsed-csv column drop-count]
     "Return a column of a csv as a vector dropping lines at beginning of the csv file."
     (get-column (drop drop-count parsed-csv) column))
  ([parsed-csv column] 
     "Return a column of a csv as a vector."
     (map #(Integer. (nth % column)) parsed-csv)))


(defn bof [x y]
  (+ x y))
