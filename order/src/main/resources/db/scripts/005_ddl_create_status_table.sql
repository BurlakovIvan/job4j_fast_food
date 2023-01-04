CREATE TABLE if not exists status (
   id SERIAL PRIMARY KEY,
   status VARCHAR NOT NULL,
   order_id INT REFERENCES orders(id),
   UNIQUE (order_id)
);