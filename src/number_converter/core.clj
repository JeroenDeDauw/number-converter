(ns number-converter.core
  (:gen-class))

(defn -main
  [& args]
  (println "Hello, World!"))

(defn convert-number [n input-form output-form]
  (nth output-form (.indexOf input-form n)))