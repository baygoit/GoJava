CREATE DATABASE airbnb;
USE airbnb;
CREATE TABLE users ( user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
						kind ENUM('host', 'client') NOT NULL,
                        name VARCHAR(40) NOT NULL,
						surname VARCHAR(40) NOT NULL,
						email VARCHAR(40) NOT NULL,
						notify BOOLEAN DEFAULT FALSE,
						ts TIMESTAMP);
						
INSERT INTO users VALUES 	(0, 'client','Jon', 'Scott', 'scott@site.com', true, CURRENT_TIMESTAMP),
                            (0, 'client','Dylan', 'Robinson', 'robinson@site.com', true, CURRENT_TIMESTAMP),
							(0, 'host','Brenda', 'Taylor', 'taylor@site.com', false, CURRENT_TIMESTAMP),
							(0, 'host','Donna', 'Small', 'small@site.com', false, CURRENT_TIMESTAMP),
							(0, 'host','Angle', 'Baker', 'baker@site.com', false, CURRENT_TIMESTAMP);
							
CREATE TABLE apartment ( apartment_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                    owner INT NOT NULL,
					city VARCHAR(20) NOT NULL,
					street VARCHAR(20) NOT NULL,
					house SMALLINT NOT NULL,
					room SMALLINT ,
					rent ENUM('place', 'room', 'apartment') NOT NULL,
					ts TIMESTAMP,
					comments VARCHAR(100));
					
INSERT INTO apartment VALUES (0, 3, 'Kiev', 'Shevchenko', 42, 11, 'room', CURRENT_TIMESTAMP);

CREATE TABLE reservation ( apartment_id INT NOT NULL PRIMARY KEY,
                    client_id INT NOT NULL,
					start DATE NOT NULL,
					end DATE NOT NULL,
					ts TIMESTAMP,
					comments VARCHAR(100));
					
SELECT * FROM users;
