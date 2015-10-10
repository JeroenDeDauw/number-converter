(ns number-converter.core
  (:gen-class))

(defn -main
  [& args]
  (println "Hello, World!"))

(defn convert-number
  ([n output-symbols]
   (convert-number n (range 10) output-symbols))
  ([n input-symbols output-symbols]
   (str (nth output-symbols (.indexOf input-symbols n)))))
