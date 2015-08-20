-- DB CREATION
CREATE DATABASE "Kickstarter"
  WITH OWNER = "Kickstarter"
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Ukrainian_Ukraine.1251'
       LC_CTYPE = 'Ukrainian_Ukraine.1251'
       CONNECTION LIMIT = -1;
GRANT CONNECT, TEMPORARY ON DATABASE "Kickstarter" TO public;
GRANT ALL ON DATABASE "Kickstarter" TO "Kickstarter";

-- ROLE and USER with *any* password - password must be specified in db.properties in src/resources/props/
CREATE ROLE "Kickstarter"
  
SUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;

CREATE ROLE app LOGIN
  
	ENCRYPTED PASSWORD *any* 
	SUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;

GRANT "Kickstarter" TO app;

-- SCHEMA
CREATE SCHEMA app
  AUTHORIZATION "Kickstarter";


GRANT ALL ON SCHEMA app TO "Kickstarter" WITH GRANT OPTION;

-- DDL - run src/main/scripts/Kickstarter_DB_DDL.sql

-- DATA UPLOAD - run src/main/scripts/Kickstarter_DB_INITIAL_DATA_UPLOAD.sql