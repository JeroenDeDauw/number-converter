(ns number-converter.core-test
  (:require [clojure.test :refer :all]
            [number-converter.core :refer :all]))


(deftest decimal-to-binary
  (is (= "0" (convert-number 0 [0 1])))
  (is (= "1" (convert-number 1 [0 1])))
  )

(deftest decimal-to-abc
  (is (= "a" (convert-number 0 ["a" "b" "c"])))
  (is (= "b" (convert-number 1 ["a" "b" "c"])))
  )

