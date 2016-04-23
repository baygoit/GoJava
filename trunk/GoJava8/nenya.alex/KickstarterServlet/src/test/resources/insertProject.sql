CREATE TABLE PROJECTS (
	id SERIAL PRIMARY KEY, 
	category_id INTEGER, 
	name VARCHAR(50) NOT NULL UNIQUE, 
	description VARCHAR(200) NOT NULL, 
	needed_amount INTEGER NOT NULL,
	days_remain INTEGER NOT NULL, 
	history VARCHAR(500), 
	video VARCHAR(50)
);
INSERT INTO PROJECTS (category_id, name, description, needed_amount, days_remain,
history, video) VALUES (10, 'song1',
    'Funny song!',
    2000, 7, 'History',
    'video');
INSERT INTO PROJECTS (category_id, name, description, needed_amount, days_remain,
history, video) VALUES (10, 'song2',
    'Sad song!',
    400, 3, 'History',
    'video');
