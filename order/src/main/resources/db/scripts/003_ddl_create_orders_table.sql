CREATE TABLE if not exists orders (
   id SERIAL PRIMARY KEY,
   name VARCHAR NOT NULL UNIQUE,
   created TIMESTAMP NOT NULL,
   customer_id INT REFERENCES customers(id)
);