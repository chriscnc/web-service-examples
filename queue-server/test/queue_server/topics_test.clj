(ns queue-server.topics-test
  (:require [clojure.test :refer :all]
            [queue-server.topics :refer :all]))


(deftest test-public-interface
  (testing "Initialization"
    (is (= (get-topics-list) nil))
    (is (zero? (get-message-count "non-existent topic"))))

  (testing "Push"
    (let [_ (push-message "t1" "m1")]
      (is (= (get-topics-list) ["t1"]))
      (is (= (peek-message "t1") "m1"))
      (is (= 1 (get-message-count "t1")))))

  (testing "Pop"
    (let [_ (push-message "t1" "m2")
          m (pop-message "t1")]
      (is (= (peek-message "t1") "m2"))
      (is (= m "m1"))))
  )



