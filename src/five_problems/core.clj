(ns five-problems.core
  (:gen-class)
  (:use [five-problems.problem-1 :only [problem-1]]
        [five-problems.problem-2 :only [problem-2]]
        [five-problems.problem-3 :only [problem-3]]
        [five-problems.problem-4 :only [problem-4]]
        [five-problems.problem-5 :only [problem-5]]))

(defn -main 
  "Run each of the problems from here"  
  [& args]
  (do
    (println "problem-1")
    (problem-1)
    (println)
    (println "problem-2")
    (println (problem-2))
    (println)
    (println "problem-3")
    (println (problem-3))
    (println)
    (println "problem-4")
    (problem-4)
    (println)
    (println "problem-5")
    (println (problem-5))
    (println)
))
