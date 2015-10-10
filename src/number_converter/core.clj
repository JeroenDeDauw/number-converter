(ns number-converter.core
  (:gen-class))

(use 'clojure.math.numeric-tower)

(defn -main
  [& args]
  (println "Hello, World!"))

(defn convert-number
  ([n output-symbols]
   (loop [n n
          step 1
          acc '()]
     (if (< n 1)
       (if (= step 1) [(first output-symbols)] acc)
       (let [symbol-value (rem n (expt (count output-symbols) step))]
         (recur
           (- n symbol-value)
           (inc step)
           (cons (nth output-symbols (/ symbol-value (expt (count output-symbols) (dec step)))) acc) ))))))