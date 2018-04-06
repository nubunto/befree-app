(ns befree-api.api
    (:require [compojure.core :refer :all]
              [compojure.route :as route]
              [cheshire.core :as json]
              [ring.util.response :refer [response]]))

(defn home
    [request]
    (response {:message "hello, api!"}))

(defroutes api-routes
    (GET "/" [] home))
