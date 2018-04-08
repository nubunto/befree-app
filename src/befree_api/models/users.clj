(ns befree-api.models.users
  (:refer-clojure :exclude [update])
  (:require [oksql.core :as oksql]
            [befree-api.models.sql :refer [*db*]]
            [crypto.password.bcrypt :refer [encrypt]]))

(defn all
  []
  (oksql/query *db* :users/all))

(defn fetch
  [id]
  (oksql/query *db* :users/fetch {:id id}))

(defn create
  [m]
  (let [m (clojure.core/update m :password encrypt)]
    (oksql/insert *db* :users m)))

(defn update
  [id m]
  (oksql/update *db* :users m :users/where {:id id}))

(defn delete
  [id]
  (oksql/delete *db* :users :users/where {:id id}))
