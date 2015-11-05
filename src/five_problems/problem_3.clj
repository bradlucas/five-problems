(ns five-problems.problem-3)

;; Problem 3

;; Write a function that computes the list of the first 100 Fibonacci
;; numbers. By definition, the first two numbers in the Fibonacci
;; sequence are 0 and 1, and each subsequent number is the sum of the
;; previous two. As an example, here are the first 10 Fibonnaci
;; numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, and 34.


;; recursive function (will time out for large numbers)
;; (defn fibonacci 
;;   [n]
;;   (cond
;;     (< n 2) n
;;     :else (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))

;; (map fibonacci (range 10)) => (0 1 1 2 3 5 8 13 21 34)




;; A lazy sequence of fibonacci numbers. Use Take to get them
;; notice the +' to support large numbers
(def fib-seq 
  ((fn rfib [a b] 
     (lazy-seq (cons a (rfib b (+' a b)))))
   0 1))

(defn fibonacci [n]
  (take n fib-seq))


(defn problem-3 []
  (fibonacci 100))


