(ns number-converter.core-test
  (:require [clojure.test :refer :all]
            [number-converter.core :refer :all]))

(deftest a-test
  (testing "Decimal 0 is Binary 0"
    (= 0 (convert-number 0 (range 10) [0 1]))))

