CREATE TABLE if not exists customers {
  id SERIAL PRIMARY KEY,
  name varchar NOT NULL,
  address varchar,
  email varchar NOT NULL,
  UNIQUE (email)
}