-- users.sql

-- name: fetch
-- fn: first
select id, name, password FROM users WHERE id = :id

-- name: all
SELECT id, name, password FROM users

-- name: insert
-- fn: first
INSERT INTO users (name, password) VALUES (:name, :password) RETURNING *

-- name: update
-- fn: first
UPDATE users SET name = :name, password = :password WHERE id = :id RETURNING *

-- name: delete
-- fn: first
DELETE FROM users WHERE id = :id RETURNING *