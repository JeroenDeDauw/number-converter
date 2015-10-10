(ns number-converter.core
  (:gen-class))

(use 'clojure.math.numeric-tower)

(defn -main
  [& args]
  (println "Hello, World!"))

(defn decimal-to-number [n output-symbols]
  (loop [n n
         step 1
         acc '()]
    (if (< n 1)
      (if (= step 1) [(first output-symbols)] acc)
      (let [symbol-value (rem n (expt (count output-symbols) step))]
        (recur
          (- n symbol-value)
          (inc step)
          (cons (nth output-symbols (/ symbol-value (expt (count output-symbols) (dec step)))) acc))))))

(defn number-to-decimal [xs input-symbols]
  (loop [xs xs
         step 0
         acc 0]
    (if (empty? xs)
      acc
      (recur (drop-last xs) (inc step) (+ acc (* (.indexOf input-symbols (last xs)) (expt (count input-symbols) step)))))))

(defn convert-number
  ([n output-symbols]
    (decimal-to-number n output-symbols))
  ([ns input-symbols output-symbols]
    (convert-number (number-to-decimal ns input-symbols) output-symbols)))
