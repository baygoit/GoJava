DROP TABLE projects;
DROP TABLE categories;

CREATE TABLE categories (
    id		int,   
    name        text,
    description text    
);

CREATE TABLE projects (
    id			int,   
    name		text,
    description		text,
    category		categories    
);