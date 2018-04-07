(ns befree-api.models.users
    (:refer-clojure :exclude [update])
    (:require [oksql.core :as oksql]
              [befree-api.models.sql :refer [datasource]]
              [crypto.password.bcrypt :refer [encrypt]]))

(def query (partial oksql/query datasource))

(defn all
    []
    (query :users/all))

(defn fetch
    [id]
    (query :users/fetch {:id id}))

(defn create
    [m]
    (let [m (clojure.core/update m :password encrypt)]
      (oksql/insert datasource :users m)))

(defn update
    [id m]
    (oksql/update datasource :users m :users/where {:id id}))

(defn delete
    [id]
    (oksql/delete datasource :users :users/where {:id id}))
