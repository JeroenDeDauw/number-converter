(ns number-converter.core-test
  (:require [clojure.test :refer :all]
            [number-converter.core :refer :all]))


(deftest decimal-to-binary
  (let [binary ["0" "1"]]
    (is (= ["0"] (convert-number 0 binary)))
    (is (= ["1"] (convert-number 1 binary)))
    (is (= ["1" "0"] (convert-number 2 binary)))
    (is (= ["1" "1"] (convert-number 3 binary)))
    (is (= ["1" "0" "0"] (convert-number 4 binary)))
    (is (= ["1" "0" "1"] (convert-number 5 binary)))
    (is (= ["1" "1" "0"] (convert-number 6 binary)))
    (is (= ["1" "1" "1"] (convert-number 7 binary)))
    ))

(deftest decimal-to-abc
  (let [abc ["a" "b" "c"]]
    (is (= ["a"] (convert-number 0 abc)))
    (is (= ["b"] (convert-number 1 abc)))
    (is (= ["c"] (convert-number 2 abc)))
    (is (= ["b" "a"] (convert-number 3 abc)))
    (is (= ["b" "b"] (convert-number 4 abc)))
    (is (= ["b" "c"] (convert-number 5 abc)))
    (is (= ["c" "a"] (convert-number 6 abc)))
    (is (= ["c" "b"] (convert-number 7 abc)))
    (is (= ["b" "a" "a"] (convert-number 9 abc)))
    ))

(deftest decimal-to-nyancat
  (let [nyancat ["Cat " "Nyan " "of doom"]
        nyanstr #(apply str %)]
    (is (= "Cat " (nyanstr (convert-number 0 nyancat))))
    (is (= "Nyan " (nyanstr (convert-number 1 nyancat))))
    (is (= "of doom" (nyanstr (convert-number 2 nyancat))))
    (is (= "Nyan Cat " (nyanstr (convert-number 3 nyancat))))
    (is (= "Nyan Cat of doom" (nyanstr (convert-number 11 nyancat))))
    ))

(deftest binary-to-dec
  (let [binary ["0" "1"]
        decimal (map str (range 10))]
    (is (= ["0"] (convert-number ["0" "0"] binary decimal)))
    (is (= ["1"] (convert-number ["0" "1"] binary decimal)))
    (is (= ["2"] (convert-number ["1" "0"] binary decimal)))
    (is (= ["3"] (convert-number ["1" "1"] binary decimal)))
    (is (= ["4" "2"] (convert-number ["1" "0" "1" "0" "1" "0"] binary decimal)))
    ))

(deftest nyancat-to-foobar
  (is (= ["bar" "foo" "baz"] (convert-number ["Nyan" "Cat" "of doom"] ["Cat" "Nyan" "of doom"] ["foo" "bar" "baz"])))
  )