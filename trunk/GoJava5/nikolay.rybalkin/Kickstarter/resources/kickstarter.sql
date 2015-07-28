BEGIN TRANSACTION;

CREATE TABLE `Projects` (
  `id`          INTEGER NOT NULL UNIQUE,
  `category_id` INTEGER NOT NULL,
  `name`        TEXT    NOT NULL,
  `description` TEXT,
  PRIMARY KEY (id, category_id)
);

INSERT INTO `Projects` (id, category_id, name, description) VALUES (1, 1, 'Project1', NULL),
  (2, 1, 'Project2', NULL);

CREATE TABLE `Category` (
  `id`   INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
  `name` TEXT    NOT NULL UNIQUE
);

INSERT INTO `Category` (id, name) VALUES (1, 'Game'),
  (2, 'Video'),
  (3, 'Music'),
  (4, 'Technology');
COMMIT;
