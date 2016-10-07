(ns queue-server.core
  (:require [compojure.core :refer :all]
            [ring.util.response :refer [response]]
            [ring.middleware.json :refer [wrap-json-response]]
            [queue-server.topics :refer :all]))


(defn get-topics
  []
  (let [topics (get-topics-list)]
    (if (zero? (count topics))
      {:topics []}
      {:topics topics})))



(defroutes app-routes
  (GET "/" [] "To get a list of topic queues, use /topics")
  (GET "/topics" [] (response (get-topics)))
;  (GET "/topics/:topic" [topic] "peeks the next message on a topic queue")
;  (POST "topics/<topic>" [] "pushes a message to a topic queue")
;  (DELETE "topics/<topic>" [] "pops the next message off the topic queue")
  )


(def app 
  (-> app-routes
      wrap-json-response))


