CREATE DATABASE kickstarter_test;
USE kickstarter_test;
    
CREATE TABLE quotes (
    id int NOT NULL AUTO_INCREMENT,
    author varchar(50) NOT NULL,
    text varchar(255) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE categories (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE projects (
    id int NOT NULL AUTO_INCREMENT,
    category_id integer NOT NULL,
    name varchar(255) NOT NULL,
    description varchar(1024),
    history varchar(1024),
    required_sum int,
    days_left int,
    video_url varchar(255),
    PRIMARY KEY (id)
    );

CREATE TABLE questions (
    id int NOT NULL AUTO_INCREMENT,
    project_id int NOT NULL,
    request varchar(1024),
    reply varchar(1024),
    PRIMARY KEY (id)
    );

CREATE TABLE rewards (
    id int NOT NULL AUTO_INCREMENT,
    project_id int NOT NULL,
    amount int NOT NULL,
    description varchar(1024),
    PRIMARY KEY (id)
    );

CREATE TABLE investments (
    id int NOT NULL AUTO_INCREMENT,
    project_id int NOT NULL,
    cardholder_name varchar(50) NOT NULL,
    card_number varchar(16) NOT NULL,
    amount int NOT NULL,
    PRIMARY KEY (id)
    );

INSERT INTO quotes (author, text) VALUES ('testauthor1','testtext1');
INSERT INTO quotes (author, text) VALUES ('testauthor2','testtext2');
INSERT INTO quotes (author, text) VALUES ('testauthor1','testtext3');
INSERT INTO quotes (author, text) VALUES ('testauthor1','testtext4');
INSERT INTO quotes (author, text) VALUES ('testauthor1','testtext5');
    
INSERT INTO categories (name) VALUES ('test1');
INSERT INTO categories (name) VALUES ('test2');
INSERT INTO categories (name) VALUES ('test3');

INSERT INTO projects (category_id, name, description, history, required_sum, days_left, video_url) VALUES
    (1, 'testname', 'testdescription', 111, 222, 'testhistory', 'testvideourl');
    
INSERT INTO questions (project_id, request, reply) VALUES (1, 'testrequest', 'testreply');
    
INSERT INTO rewards (project_id, amount, description) VALUES (1, 10, 'testdescription');
    
INSERT INTO investments (project_id, cardholder_name, card_number, amount) VALUES (1, 'testcardholdername', 'testcardnumber', 111);

GRANT ALL PRIVILEGES ON kickstarter_test . * TO 'kickstarter'@'%';
FLUSH PRIVILEGES;