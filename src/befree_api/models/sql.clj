(ns befree-api.models.sql)

;; DB configuration map
(defn db-config
    []
    {:connection-uri (or (System/getenv "BEFREE_DATABASE") "postgres://localhost:5432/befree")})
