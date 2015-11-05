(ns five-problems.problem-4
   (:require [clojure.math.combinatorics :as combo]))

;; Problem 4

;; Write a function that given a list of non negative integers, arranges
;; them such that they form the largest possible number. For example,
;; given [50, 2, 1, 9], the largest formed number is 95021.

;; First verson doesn't work for sequences like 
;; (build-largest-number [52 5 3]) => 3552
;; (defn build-largest-number [nums]
;;   (Integer. (clojure.string/join "" (reverse (map str nums)))))



;; Second version, build all the permutations of the set and 
;; then figure out which one builds the largest number
;; Going to use the cominatorics library 
;; @see https://github.com/clojure/math.combinatorics

(defn build-largest-number [nums]
  (letfn [(build-str-num [nums]
            (Integer. (clojure.string/join "" (map str nums))))]
    (reduce max (map build-str-num (combo/permutations nums)))))

;; (build-largest-number [50 2 1 9]) => 95021
;; (build-largest-number [52 5 3]) => 5523

(defn problem-4 []
  (println "[50 2 1 9] =>" (build-largest-number [50 2 1 9]))
  (println "[52 5 3] =>" (build-largest-number [52 5 3])))

