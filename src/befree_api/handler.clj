(ns befree-api.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [befree-api.api :refer [api-routes]]
            [ring.adapter.jetty :as ring]
            [ring.middleware.json :refer [wrap-json-response]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (context "/api" [] api-routes)
  (route/not-found "Not Found"))

(def app
  (wrap-json-response app-routes))
