
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

CREATE TABLE project
(
  id SERIAL NOT NULL PRIMARY KEY,
  name text,
  goalSum bigint,
  balanceSum bigint,
  startDate date,
  endDate date,
  category_id integer REFERENCES category ON DELETE CASCADE,
  description text,
  videoUrl text,
  author text
);

CREATE TABLE question
(
  question text NOT NULL PRIMARY KEY,
  answer text,
  project_id integer REFERENCES project ON DELETE CASCADE
);

CREATE TABLE reward
(
  id SERIAL NOT NULL PRIMARY KEY,
  description text,
  pledgeSum bigint,
  project_id integer REFERENCES project ON DELETE CASCADE
);

CREATE TABLE payment
(
  id SERIAL NOT NULL PRIMARY KEY,
  cardId integer,
  date date,
  username text,
  sum bigint,
  project_id integer REFERENCES project ON DELETE CASCADE,
  reward_id integer REFERENCES reward ON DELETE CASCADE
)