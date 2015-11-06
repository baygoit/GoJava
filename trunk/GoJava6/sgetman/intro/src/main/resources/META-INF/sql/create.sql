create schema jpa;

use jpa;

CREATE TABLE book (  id int(11) NOT NULL,  title varchar(45) DEFAULT NULL,  unitCost decimal(5,0) DEFAULT NULL,  isbn varchar(45) DEFAULT NULL,  nbOfPage int(11) DEFAULT NULL,  description varchar(245) DEFAULT NULL,  PRIMARY KEY (id));



