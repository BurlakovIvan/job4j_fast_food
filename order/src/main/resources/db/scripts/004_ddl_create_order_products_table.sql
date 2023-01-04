CREATE TABLE IF NOT EXISTS orderProducts (
     id SERIAL PRIMARY KEY,
     order_id int NOT NULL REFERENCES orders(id),
     product_id int NOT NULL REFERENCES products(id)
)