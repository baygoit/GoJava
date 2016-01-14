CREATE TABLE payments
(
id INTEGER NOT NULL PRIMARY KEY,
user_name VARCHAR2(100) NOT NULL,
number_card NUMBER(16) NOT NULL,
amount_donation NUMBER(10) NOT NULL,
project_id INTEGER NOT NULL,
FOREIGN KEY (project_id)
REFERENCES projects(id)
);

CREATE TABLE quotes
(
content VARCHAR2(500) NOT NULL,
author VARCHAR2(100) NOT NULL
);

CREATE TABLE categories
(
id INTEGER NOT NULL PRIMARY KEY,
name VARCHAR2(100) NOT NULL
);

CREATE TABLE rewards
(
id INTEGER NOT NULL PRIMARY KEY,
amount_donation NUMBER(10) NOT NULL,
reward VARCHAR2(100) NOT NULL,
project_id INTEGER NOT NULL,
FOREIGN KEY (project_id)
REFERENCES projects(id)
);

CREATE TABLE projects
(
id INTEGER NOT NULL PRIMARY KEY,
category_id INTEGER NOT NULL,
name VARCHAR2(200) NOT NULL,
general_description VARCHAR2(500) NOT NULL,
full_description VARCHAR2(900),
video_link VARCHAR2(200),
required_sum NUMBER(10) NOT NULL,
collected_sum NUMBER(10),
days_left NUMBER(10) NOT NULL,
FOREIGN KEY (category_id)
REFERENCES categories(id)	
);