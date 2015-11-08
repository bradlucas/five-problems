(ns five-problems.problem-5)
 
;; Problem 5

;; Write a program that outputs all possibilities to put + or - or
;; nothing between the numbers 1, 2, ..., 9 (in this order) such that the
;; result is always 100. For example: 1 + 2 + 34 - 5 + 67 - 8 + 9 = 100.

;; You are limited to one instance of each of the numbers from 1 to 9
;; The numbers are in order
;; The result must be 100

;; [1 + 2 + 34 - 5 + 67 - 8 + 9]
;; (range 1 10)
;; ----------------------------------------------------------------------------------------------------

(defn reduce-embedded-numbers 
  ;; what about [1 2 3 + 3]
  ;; (reduce-embedded-numbers [1 2 3 '+ 4]) => [123 + 4]
  [xs]
  (loop [xs xs
         res []]
    (if (not (seq xs))
      res
      (let [x (first xs)]
        (if (and (number? x) (number? (last res)))
          (let [prev (last res)
                new (+ (* prev 10) x)]
            (recur (rest xs) (conj (vec (drop-last res)) new)))
          (recur (rest xs) (conj res x)))))))

(defn evaluate-expression
  ;; Given an expression in a vector return the result of evaluating it
  ;; (evaluate-expression [38 + 48 - 2 / 2]) => 42
  ;; 
  ;; Loop over the sequence
  ;; if we have a number apply the previous operator to the accumulator and the number
  ;; otherwise loop and remember the operator for the next number
  ;;
  ;; http://stackoverflow.com/a/10967871
  [exp]
  (let [exp (reduce-embedded-numbers exp)]
    (loop [exp exp
           acc 0
           oper '+]
      (let [x (first exp)]
        (if (nil? x) acc
            (let [xs (rest exp)]
              (cond 
                (number? x) (recur xs ((resolve (symbol oper)) acc x) nil)
                :else (recur xs acc x))))))))

;; (is-100? [123 - 45 - 67 + 89]) => true
(defn is-100? [xs] (= (evaluate-expression xs) 100))

(defn greater-100? [xs] (> (evaluate-expression xs) 100))


;; Build all the combinations of the numbers 1 to 9 with +, - and space
;; Loop over all the combinations of [1..9] and [+. -, nil]
;; For each return the combinations that evaluate to 100


(defn next-possibilities [digits exp]
  ;; 1 +
  ;; 1 -
  ;; 12
  ;; assume two digits
  (let [a (first digits)
        b (second digits)
        xs (rest digits)]
    [[xs (conj exp a '+)]
     [xs (conj exp a '-)]
     [xs (conj exp a)]]))


(defn build-expressions 
  ;; (pprint (build-expressions [1 2 3]))
  ;; ([1 + 2 + 3]
  ;;  [1 + 2 - 3]
  ;;  [1 + 2 3]
  ;;  [1 - 2 + 3]
  ;;  [1 - 2 - 3]
  ;;  [1 - 2 3]
  ;;  [1 2 + 3]
  ;;  [1 2 - 3]
  ;;  [1 2 3])
  ([digits] (build-expressions digits []))
  ([digits exp]
    (if (seq digits)
      (if (= 1 (count digits))
        (vector (conj exp (first digits)))
        (mapcat 
         (fn [[x y]] (build-expressions x y)) 
         (next-possibilities digits exp)))
      (vector exp))))

;; (defn run []
;;   (let [exps (build-expressions (range 1 10))]
;;     (map reduce-embedded-numbers (filter is-100? exps))
;;     )
;; )

;; (defn run []
;;   (map reduce-embedded-numbers (filter is-100? (build-expressions (range 1 10)))))

(defn run []
  (->> (range 1 10)
      build-expressions
      (filter is-100?)
      (map reduce-embedded-numbers)))




