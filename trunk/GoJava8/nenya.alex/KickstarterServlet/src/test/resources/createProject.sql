CREATE TABLE PROJECT (
    id SERIAL PRIMARY KEY, 
    category_id INTEGER, 
    name VARCHAR(50) NOT NULL UNIQUE, 
    description VARCHAR(200) NOT NULL, 
    needed_amount INTEGER NOT NULL,
    remaining_days INTEGER NOT NULL, 
    history VARCHAR(500), 
    video VARCHAR(50)
);