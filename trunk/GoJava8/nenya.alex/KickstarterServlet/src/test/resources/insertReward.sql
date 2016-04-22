CREATE TABLE REWARDS (id SERIAL PRIMARY KEY, project_id INTEGER, name VARCHAR(50) NOT NULL, amount INTEGER, description VARCHAR(200));
INSERT INTO Rewards (project_id, name, amount, description) VALUES (1, '100$', 100, 'Reward100');
INSERT INTO Rewards (project_id, name, amount, description) VALUES (1, '200$', 200, 'Reward200');
INSERT INTO Rewards (project_id, name, amount, description) VALUES (2, '300$', 300, 'Reward300');