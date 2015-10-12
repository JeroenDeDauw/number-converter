(ns number-converter.core
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:require [clojure.string :as str])
  (:gen-class))

(use 'clojure.math.numeric-tower)

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
      (recur
        (drop-last xs)
        (inc step)
        (+ acc (* (.indexOf input-symbols (last xs)) (expt (count input-symbols) step)))))))

(defn convert-number
  ([n output-symbols]
   (decimal-to-number n output-symbols))
  ([ns input-symbols output-symbols]
   (convert-number (number-to-decimal ns input-symbols) output-symbols)))

(defn converter-number-input [ns input-symbols output-symbols]
  (convert-number
    (str/split ns #" ")
    (str/split input-symbols #" ")
    (str/split output-symbols #" ")))

(def cli-options
  ;; An option with a required argument
  [["-n" "--number SYMBOLS" "Symbols of the number to convert"
    ]
   ["-i" "--input SYMBOLS" "Symbols defining the input system"
    ]
   ["-o" "--output SYMBOLS" "Symbols defining the output system"
    ]
   ["-h" "--help"]])

(defn -main [& args]
  (let [cli-input (parse-opts args cli-options)]
    (if (nil? (cli-input :errors))
      (let [options (cli-input :options)]
        (if (true? (options :help))
          (println (cli-input :summary))
          (println (converter-number-input
                     (options :number)
                     (options :input)
                     (options :output)))))
      ((println (cli-input :errors)) (println (cli-input :summary))))))
