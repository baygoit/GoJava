CREATE TABLE QUOTE (id SERIAL PRIMARY KEY, name VARCHAR(200) NOT NULL UNIQUE);
INSERT INTO QUOTE (name) VALUES ('Healthy curiosity is a great key in innovation.');
INSERT INTO QUOTE (name) VALUES ('Everyone here has the sense that right now is one of those moments when we are influencing the future.');
INSERT INTO QUOTE (name) VALUES ('Great things in business are never done by one person. They are done by a team of people.');

CREATE TABLE CATEGORY (id SERIAL PRIMARY KEY, name VARCHAR(50) NOT NULL UNIQUE);
INSERT INTO CATEGORY (name) VALUES ('Music');
INSERT INTO CATEGORY (name) VALUES ('Films');
INSERT INTO CATEGORY (name) VALUES ('Art');

CREATE TABLE PROJECT (id SERIAL PRIMARY KEY, category_id INTEGER REFERENCES CATEGORY, name VARCHAR(50) NOT NULL UNIQUE, 
description VARCHAR(200) NOT NULL, needed_amount INTEGER NOT NULL,
remaining_days INTEGER NOT NULL, history VARCHAR(500), video VARCHAR(50));
INSERT INTO PROJECT (category_id, name, description, needed_amount, remaining_days,
history, video) VALUES (1, 'A new funny song',
    'We want to write a new funny song!',
    2000, 7, 'History of funny song',
    'video about funny song');
INSERT INTO PROJECT (category_id, name, description, needed_amount, remaining_days,
history, video) VALUES (1, 'A lonely song',
    'We want to write a new sad song!',
    400, 3, 'History of lonely song',
    'video about lonely song');
INSERT INTO PROJECT (category_id, name, description, needed_amount, remaining_days,
history, video) VALUES (2, 'Terminator 88',
    'All money we will gather is for new blockbuster!',
    200000, 365, 'History of Terminator',
    'video about Terminator');
INSERT INTO PROJECT (category_id, name, description, needed_amount, remaining_days,
history, video) VALUES (2, 'Dirty Garry',
    'It will be a western about wild west!',
    10000, 150, 'History of wild west',
    'video about Garry');
INSERT INTO PROJECT (category_id, name, description, needed_amount, remaining_days,
history, video) VALUES (3, 'Exhibition of photos',
    'Exhibition of photos of Kiev!',
    7000, 15, 'History of photos',
    'video about exhibition');
INSERT INTO PROJECT (category_id, name, description, needed_amount, remaining_days,
history, video) VALUES (3, 'Exhibition of plates',
    'Exhibition of old plates!',
    100000, 120, 'History of plates',
    'video about exhibition');
    
CREATE TABLE REWARD (id SERIAL PRIMARY KEY, project_id INTEGER REFERENCES PROJECT, name VARCHAR(50) NOT NULL, amount INTEGER, description VARCHAR(200));
INSERT INTO REWARD (project_id, name, amount, description) VALUES (1, '100$', 100, 'Invest one hundred dollars and get bottle of water!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (1, '100$', 100, 'Invest one hundred dollars and get five bottles of water!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (1, '200$', 200, 'Invest two hundreds dollars and get two tickets to the movie!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (1, '200$', 200, 'Invest two hundreds dollars and get tickets to the movie for all family!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (1, '500$', 500, 'Invest five hundreds dollars and get a lunch for two persons in the restaurant!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (2, '100$', 100, 'Invest one hundred dollars and get bottle of water!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (2, '100$', 100, 'Invest one hundred dollars and get five bottles of water!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (3, '200$', 200, 'Invest two hundreds dollars and get two tickets to the movie!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (3, '200$', 200, 'Invest two hundreds dollars and get tickets to the movie for all family!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (3, '500$', 500, 'Invest five hundreds dollars and get a lunch for two persons in the restaurant!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (4, '100$', 100, 'Invest one hundred dollars and get bottle of water!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (4, '100$', 100, 'Invest one hundred dollars and get five bottles of water!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (4, '200$', 200, 'Invest two hundreds dollars and get two tickets to the movie!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (4, '200$', 200, 'Invest two hundreds dollars and get tickets to the movie for all family!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (4, '500$', 500, 'Invest five hundreds dollars and get a lunch for two persons in the restaurant!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (5, '100$', 100, 'Invest one hundred dollars and get bottle of water!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (5, '100$', 100, 'Invest one hundred dollars and get five bottles of water!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (5, '200$', 200, 'Invest two hundreds dollars and get two tickets to the movie!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (5, '200$', 200, 'Invest two hundreds dollars and get tickets to the movie for all family!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (5, '500$', 500, 'Invest five hundreds dollars and get a lunch for two persons in the restaurant!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (6, '100$', 100, 'Invest one hundred dollars and get bottle of water!!!');
INSERT INTO REWARD (project_id, name, amount, description) VALUES (6, '100$', 100, 'Invest one hundred dollars and get five bottles of water!!!');

CREATE TABLE QUESTION (id SERIAL PRIMARY KEY, project_id INTEGER REFERENCES PROJECT, name VARCHAR(500) NOT NULL);
--ALTER TABLE QUESTION ADD CONSTRAINT uq_Question UNIQUE(project_id, name(255));--
INSERT INTO QUESTION (project_id, name) VALUES (1, 'Why?');
INSERT INTO QUESTION (project_id, name) VALUES (1, 'Who?');
INSERT INTO QUESTION (project_id, name) VALUES (2, 'What?');
INSERT INTO QUESTION (project_id, name) VALUES (2, 'Which?');
INSERT INTO QUESTION (project_id, name) VALUES (3, 'Is it really?');
INSERT INTO QUESTION (project_id, name) VALUES (3, 'Why?');
INSERT INTO QUESTION (project_id, name) VALUES (4, 'Who?');
INSERT INTO QUESTION (project_id, name) VALUES (4, 'What?');
INSERT INTO QUESTION (project_id, name) VALUES (5, 'Which?');
INSERT INTO QUESTION (project_id, name) VALUES (5, 'Is it really?');
INSERT INTO QUESTION (project_id, name) VALUES (6, 'Why?');
INSERT INTO QUESTION (project_id, name) VALUES (6, 'Who?');
INSERT INTO QUESTION (project_id, name) VALUES (6, 'What?');
INSERT INTO QUESTION (project_id, name) VALUES (6, 'Which?');
INSERT INTO QUESTION (project_id, name) VALUES (6, 'Is it really?');

CREATE TABLE PAYMENT (id SERIAL PRIMARY KEY, project_id INTEGER REFERENCES PROJECT, amount INTEGER);
INSERT INTO PAYMENT (project_id, amount) VALUES (1, 25);
INSERT INTO PAYMENT (project_id, amount) VALUES (1, 75);
INSERT INTO PAYMENT (project_id, amount) VALUES (2, 10);
INSERT INTO PAYMENT (project_id, amount) VALUES (2, 100);
INSERT INTO PAYMENT (project_id, amount) VALUES (2, 90);
INSERT INTO PAYMENT (project_id, amount) VALUES (3, 300);
INSERT INTO PAYMENT (project_id, amount) VALUES (4, 125);
INSERT INTO PAYMENT (project_id, amount) VALUES (4, 75);
INSERT INTO PAYMENT (project_id, amount) VALUES (4, 122);
INSERT INTO PAYMENT (project_id, amount) VALUES (4, 78);
INSERT INTO PAYMENT (project_id, amount) VALUES (5, 350);
INSERT INTO PAYMENT (project_id, amount) VALUES (5, 150);
INSERT INTO PAYMENT (project_id, amount) VALUES (6, 533);
INSERT INTO PAYMENT (project_id, amount) VALUES (6, 67);