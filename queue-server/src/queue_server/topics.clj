(ns queue-server.topics)


(def ^:private topics 
  "Top-level topics collection"
  (ref {}))


(defn- empty-queue
  "Returns a new empty PeristentQueue"
  []
  (clojure.lang.PersistentQueue/EMPTY))


(defn- add-topic
  "Add a topic to the topics collection"
  [new-t]
  (dosync
    (if (not (contains? @topics new-t))
      (alter topics assoc new-t (atom (empty-queue)))
      @topics)))


(defn get-topics-list
  "Return a sequence of topic ids."
  []
  (keys @topics))


(defn get-message-count
  "Return the size of a topic queue"
  [topic]
  (if (contains? @topics topic)
    (let [q (get @topics topic)]
      (count @q))
    0))


(defn push-message
  "Adds a message to a queue"
  [topic msg]
  (dosync
    (add-topic topic)
    (let [q (get @topics topic)]
      (swap! q conj msg))))


(defn peek-message
  "Peek at the next message on a queue"
  [topic]
  (let [q (get @topics topic)]
    (peek @q)))


(defn pop-message
  "Pop the next message off the queue. Returns
  the message that was popped."
  [topic]
  (dosync
    (let [q (get @topics topic)
          msg (peek @q)]
      (swap! q pop)
      msg)))

