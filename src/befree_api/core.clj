(ns befree-api.core
    (:require [befree-api.handler :as api-handlers]
              [aleph.http :as http])
    (:gen-class))

(defn start
    [port app]
    (do
        (println "starting server on port" port)
        (http/start-server app {:port port})))
        
(defn -main
    [& args]
    (let [port (or (System/getenv "PORT") 3000)]
        (start port #'api-handlers/app)))
