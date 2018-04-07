(ns befree-api.api-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [clojure.java.jdbc :as jdbc]
            [befree-api.api :refer :all]))

(defn test-db
  []
  {:connection-uri "jdbc:postgresql:befree-test?user=postgres&password=postgres"})

(deftest api-test
  (testing "users: fetch all users in a empty db must return no users"
    (binding [befree-api.models.sql/*db* (test-db)]
      (let [response (all-users (hash-map))]
        (is (= 200 (:status response)))
        (is (= 0 (count (:body response))))))))
