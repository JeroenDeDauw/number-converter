(ns number-converter.core-test
  (:require [clojure.test :refer :all]
            [number-converter.core :refer :all]))


(deftest decimal-to-binary
  (is (= ["0"] (convert-number 0 ["0" "1"])))
  (is (= ["1"]  (convert-number 1 ["0" "1"])))
  (is (= ["1" "0"] (convert-number 2 ["0" "1"])))
  (is (= ["1" "1"] (convert-number 3 ["0" "1"])))
  (is (= ["1" "0" "0"] (convert-number 4 ["0" "1"])))
  (is (= ["1" "0" "1"] (convert-number 5 ["0" "1"])))
  (is (= ["1" "1" "0"] (convert-number 6 ["0" "1"])))
  (is (= ["1" "1" "1"] (convert-number 7 ["0" "1"])))
  )

(deftest decimal-to-abc
  (is (= ["a"] (convert-number 0 ["a" "b" "c"])))
  (is (= ["b"] (convert-number 1 ["a" "b" "c"])))
  (is (= ["c"] (convert-number 2 ["a" "b" "c"])))
  (is (= ["b" "a"] (convert-number 3 ["a" "b" "c"])))
  (is (= ["b" "b"] (convert-number 4 ["a" "b" "c"])))
  (is (= ["b" "c"] (convert-number 5 ["a" "b" "c"])))
  (is (= ["c" "a"] (convert-number 6 ["a" "b" "c"])))
  (is (= ["c" "b"] (convert-number 7 ["a" "b" "c"])))
  (is (= ["b" "a" "a"] (convert-number 9 ["a" "b" "c"])))
  )

