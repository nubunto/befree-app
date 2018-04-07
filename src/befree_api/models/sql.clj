(ns befree-api.models.sql
  (:require [hikari-cp.core :refer [make-datasource]]))

(def datasource-options
  {:auto-commit        true
   :read-only          false
   :idle-timeout       600000
   :validation-timeout 5000
   :connection-timeout 30000
   :max-lifetime       1800000
   :minimum-idle       10
   :maximum-pool-size  10
   :pool-name          "db-pool"
   :adapter            "postgresql"
   :username           "postgres"
   :password           "postgres"
   :database-name      "befree"
   :server-name        "localhost"
   :port-number        5432
   :register-mbeans    false})

(def ^:dynamic *db* {:datasource (make-datasource datasource-options)})
