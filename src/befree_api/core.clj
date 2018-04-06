(ns befree-api.core
    (:require [befree-api.handler :as api-handlers]
              [ring.adapter.jetty :as ring])
    (:gen-class))

(defn start
    [port app]
    (ring/run-jetty app {:port port :join? false}))
        
(defn -main
    [& args]
    (let [port (or (System/getenv "PORT") 3000)]
        (start port #'api-handlers/app)))
