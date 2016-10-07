(ns hit-counter.core
  (:require [compojure.core :refer :all]))

(def counter (atom 0))

(defroutes handler
  (GET "/" [] 
       (do (Thread/sleep 1000)
           (swap! counter inc)
           (str "<p>hits: " @counter "</p>"))))
