(ns befree-api.core
    (:require [befree-api.handler :as api-handlers]
              [ring.adapter.jetty :as ring])
    (:gen-class))

(defn -main
    [& args]
    (ring/run-jetty #'api-handlers/app {:port (or (System/getenv "PORT") 3000) :join? false}))