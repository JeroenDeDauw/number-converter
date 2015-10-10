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

(defn nyanstr [s] (apply str s))

(deftest decimal-to-nyancat
  (is (= "Cat " (nyanstr (convert-number 0 ["Cat " "Nyan " "of doom"]))))
  (is (= "Nyan " (nyanstr (convert-number 1 ["Cat " "Nyan " "of doom"]))))
  (is (= "of doom" (nyanstr (convert-number 2 ["Cat " "Nyan " "of doom"]))))
  (is (= "Nyan Cat " (nyanstr (convert-number 3 ["Cat " "Nyan " "of doom"]))))
  (is (= "Nyan Cat of doom" (nyanstr (convert-number 11 ["Cat " "Nyan " "of doom"])))))

(deftest binary-to-dec
  (is (= ["0"] (convert-number ["0" "0"] ["0" "1"] (map str (range 10)))))
  (is (= ["1"] (convert-number ["0" "1"] ["0" "1"] (map str (range 10)))))
  (is (= ["2"]  (convert-number ["1" "0"] ["0" "1"] (map str (range 10)))))
  (is (= ["3"]  (convert-number ["1" "1"] ["0" "1"] (map str (range 10)))))
  (is (= ["4" "2"]  (convert-number ["1" "0" "1" "0" "1" "0"] ["0" "1"] (map str (range 10)))))
  )

(deftest nyancat-to-foobar
  (is (= ["bar" "foo" "baz"] (convert-number ["Nyan" "Cat" "of doom"] ["Cat" "Nyan" "of doom"] ["foo" "bar" "baz"])))
  )