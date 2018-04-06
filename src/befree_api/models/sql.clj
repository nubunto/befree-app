(ns befree-api.models.sql)

;; DB configuration map
(def db {:connection-uri (or (System/getenv "BEFREE_DATABASE") "jdbc:postgresql://localhost:5432/befree?user=postgres&password=postgres")})