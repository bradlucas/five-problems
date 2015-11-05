(ns five-problems.problem-1)

;; Problem 1

;; Write three functions that compute the sum of the numbers in a
;; given list using a for-loop, a while-loop, and recursion.

;; apply
(defn sum-apply [nums]
  (apply + nums))

;; reduce
(defn sum-reduce [nums]
  (reduce + nums)
)

;; for-loop
(defn sum-for [nums]
  (let [total (atom 0)]
    (dorun 
     (for [i nums]
       (swap! total #(+ % i))))
    @total))

;; while
(defn sum-while [nums]
  (let [cnt (atom (count nums))
        total (atom 0)
        ]
    (while (pos? @cnt)
      (do
       (swap! total #(+ % (nth nums (dec @cnt))))
       (swap! cnt #(- % 1))        
        )
      )
    @total))

;; recursion
(defn sum-recur [nums]
  (loop [nums nums
         acc 0]
    (if (empty? nums)
      acc
      (recur (rest nums)(+ acc (first nums))))))

;; (sum [1 2 3 4]) => 10

(defn problem-1 []
  (let [nums [1 2 3 4]]
    (println "nums => " nums)
    (println "sum-apply =>" (sum-apply nums))
    (println "sum-reduce =>" (sum-reduce nums))
    (println "sum-for =>" (sum-for nums))
    (println "sum-while =>" (sum-while nums))
    (println "sum-recur =>" (sum-recur nums))))
