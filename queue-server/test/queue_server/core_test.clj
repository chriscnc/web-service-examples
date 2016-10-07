(ns queue-server.core-test
  (:require [clojure.test :refer :all]
            [queue-server.core :refer :all]
            [ring.mock.request :as mock]))


(deftest handler-test
  (is (= (app (mock/request :get "/"))
         {:status  200
          :headers {"Content-Type" "text/html; charset=utf-8"}
          :body    "To get a list of topic queues, use /topics"}))

  (is (= (app (mock/request :get "/topics"))
         {:status 200 
          :headers {"Content-Type" "application/json; charset=utf-8"}
          :body "{\"topics\":[]}"}))
  )



