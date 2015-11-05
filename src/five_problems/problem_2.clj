(ns five-problems.problem-2)

;; Problem 2

;; Write a function that combines two lists by alternatingly taking
;; elements. For example: given the two lists [a, b, c] and [1, 2, 3],
;; the function should return [a, 1, b, 2, c, 3].

(defn merge [a b]
  (interleave a b))


(defn problem-2 []
  (let [l1 [:a :b :c]
        l2 [1 2 3]]
    (merge l1 l2)))
