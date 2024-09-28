# --- !Ups

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  password VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL
);

# --- !Downs

DROP TABLE users;
