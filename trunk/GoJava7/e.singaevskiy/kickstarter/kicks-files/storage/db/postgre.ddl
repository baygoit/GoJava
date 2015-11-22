
CREATE TABLE quote
(
  text text NOT NULL PRIMARY KEY,
  author text
);

CREATE TABLE category
(
  id SERIAL NOT NULL PRIMARY KEY,
  name text
);