CREATE TABLE CATEGORIES (id SERIAL PRIMARY KEY, name VARCHAR(50) NOT NULL UNIQUE);
INSERT INTO CATEGORIES (name) VALUES ('Music');
INSERT INTO CATEGORIES (name) VALUES ('Films');