--CREEATE TEST TABLES--
DROP TABLE projects;
DROP TABLE categories;
 
CREATE TABLE categories (
    category_id          	SERIAL 	NOT NULL,   
    name        		text 	NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (category_id)
);

CREATE TABLE projects (
    project_id          SERIAL NOT NULL,   
    category_id		int NOT NULL,
    name                text NOT NULL,
    description         text,
    need_sum         	int,
    current_sum      	int,
    days_left        	int,
    project_history  	text,
    link_on_video     	text,
    questions_and_answers text,
    CONSTRAINT pk_project PRIMARY KEY (project_id),
	CONSTRAINT fk1_projec FOREIGN KEY (category_id)
	REFERENCES categories (category_id) MATCH SIMPLE
	ON UPDATE CASCADE ON DELETE CASCADE
);
--CREEATE TEST TABLES--
