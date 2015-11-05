(ns five-problems.core
  (:use [five-problems.problem-1 :only [problem-1]]
        [five-problems.problem-2 :only [problem-2]]
        [five-problems.problem-3 :only [problem-3]]
        [five-problems.problem-4 :only [problem-4]]
        [five-problems.problem-5 :only [problem-5]]))

(defn -main
  "Run each of the problems from here"  
  []
  (do
    (problem-1)
    (problem-2)
    (problem-3)
    (problem-4)
    (problem-5)))
