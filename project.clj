(defproject number-converter "0.1.0-SNAPSHOT"
  :description "Arbitrary numerical system number converter written in Clojure"
  :url "https://github.com/JeroenDeDauw/number-converter"
  :license {:name "GNU GPL v2+"
            :url "http://www.gnu.de/documents/gpl-2.0.en.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/math.numeric-tower "0.0.4"]]
  :main ^:skip-aot number-converter.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
