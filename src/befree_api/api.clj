(ns befree-api.api
    (:require [compojure.core :refer :all]
              [compojure.route :as route]
              [cheshire.core :as json]
              [ring.util.response :refer [response]]
              [befree-api.models.users :as users]))

(defn home
    [request]
    (response {:message "hello, api!"}))

(defn create-user
    [request]
    (response {:message "wait a sec"}))

(defn get-user
    [{:keys [params]}]
    (response (users/fetch (Integer. (:id params)))))

(defn all-users
    [request]
    (response (users/all)))

(defroutes api-routes
    (GET "/" [] home)
    (GET "/users/:id" [] get-user)
    (GET "/users/" [] all-users)
    (POST "/users/" [] create-user))
