CREATE DATABASE kickstarter;
USE kickstarter;

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
    
INSERT INTO quotes (author, text) VALUES ('David Allen','You can do anything, but not everything');
INSERT INTO quotes (author, text) VALUES ('Wayne Gretzky','You miss 100 percent of the shots you never take.');
INSERT INTO quotes (author, text) VALUES ('Abraham Maslow','To the man who only has a hammer, everything he encounters begins to look like a nail.');
INSERT INTO quotes (author, text) VALUES ('Oscar Levant','What the world needs is more geniuses with humility, there are so few of us left.');
INSERT INTO quotes (author, text) VALUES ('Lily Tomlin','Sometimes I worry about being a success in a mediocre world.');
INSERT INTO quotes (author, text) VALUES ('Andre Gide','Believe those who are seeking the truth. Doubt those who find it.');
INSERT INTO quotes (author, text) VALUES ('Charles F. Kettering','An inventor is simply a fellow who does not take his education too seriously.');
INSERT INTO quotes (author, text) VALUES ('House M.D.','Everybody lies.');

INSERT INTO categories (name) VALUES ('Sport');
INSERT INTO categories (name) VALUES ('Space investigation');
INSERT INTO categories (name) VALUES ('Game development');

INSERT INTO projects (category_id, name, description, required_sum, days_left, history, video_url) VALUES
    (1, 'Chess competition in Vasyuki-city', 'The grandest chess tournament in the world.', 300, 1, 'Here should be the project history... or your advertising', 'http://new-vasyuki.ru');
INSERT INTO projects (category_id, name, description, required_sum, days_left, history, video_url) VALUES
    (1, 'New football team creation', 'We are going to create football dream team called "Berdychiv".', 500000, 300, 'Here should be the project history... or your advertising', 'http://bestliga.i.ua');
INSERT INTO projects (category_id, name, description, required_sum, days_left, history, video_url) VALUES
    (2, 'Solar expedition', 'We are going to organize night expedition to Sun', 1000, 31, 'Here should be the project history... or your advertising', 'http://newhome.com');
INSERT INTO projects (category_id, name, description, required_sum, days_left, history, video_url) VALUES
    (2, 'Growing of apple-trees at Mars', 'The best of space and agriculture together!', 35000, 60, 'Here should be the project history... or your advertising', 'http://notthatapple.com');
INSERT INTO projects (category_id, name, description, required_sum, days_left, history, video_url) VALUES
    (3, 'World of managers', 'New amazing online game - feel yourself as an office employee!', 50100, 120, 'Here should be the project history... or your advertising', 'http://wom.com');
INSERT INTO projects (category_id, name, description, required_sum, days_left, history, video_url) VALUES
    (3, 'Beer drinker simulator', 'Most realistic physic ever!', 20500, 309, 'Here should be the project history... or your advertising', 'http://twobeerornottwobeer.to');

INSERT INTO questions (project_id, request, reply) VALUES (1, 'What is the meaning of life?', '42');
INSERT INTO questions (project_id, request, reply) VALUES (2, 'What is the meaning of life?', '42');
INSERT INTO questions (project_id, request, reply) VALUES (3, 'What is the meaning of life?', '42');
INSERT INTO questions (project_id, request, reply) VALUES (4, 'What is the meaning of life?', '42');
INSERT INTO questions (project_id, request, reply) VALUES (5, 'What is the meaning of life?', '42');
INSERT INTO questions (project_id, request, reply) VALUES (6, 'What is the meaning of life?', '42');

INSERT INTO rewards (project_id, amount, description) VALUES (1, 10, 'You are a friend.');
INSERT INTO rewards (project_id, amount, description) VALUES (1, 20, 'You are a best friend.');
INSERT INTO rewards (project_id, amount, description) VALUES (2, 50, 'A free ticket');
INSERT INTO rewards (project_id, amount, description) VALUES (2, 100, 'You`re a team leader.');
INSERT INTO rewards (project_id, amount, description) VALUES (3, 5, 'Cool postcard.');
INSERT INTO rewards (project_id, amount, description) VALUES (3, 7, 'Ticket to the Sun.');
INSERT INTO rewards (project_id, amount, description) VALUES (4, 500, 'A pack of apple charcoal.');
INSERT INTO rewards (project_id, amount, description) VALUES (4, 1000, 'Iphone 7z.');
INSERT INTO rewards (project_id, amount, description) VALUES (5, 20, 'Magic chair.');
INSERT INTO rewards (project_id, amount, description) VALUES (5, 200, 'Golden parachute.');
INSERT INTO rewards (project_id, amount, description) VALUES (6, 100, 'Free bottle of beer.');
INSERT INTO rewards (project_id, amount, description) VALUES (6, 1000, 'Two bottles of beer and we will call you best friend for a whole day.');

CREATE USER 'kickstarter'@'%' IDENTIFIED BY '123';
GRANT ALL PRIVILEGES ON kickstarter . * TO 'kickstarter'@'%';
FLUSH PRIVILEGES;
