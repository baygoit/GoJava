CREATE DATABASE kickstarter_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';

CREATE TABLE categories (
    id bigint NOT NULL,
    name text NOT NULL
);

CREATE SEQUENCE categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE categories_id_seq OWNED BY categories.id;

CREATE TABLE projects (
    id bigint NOT NULL,
    category_id bigint NOT NULL,
    name text NOT NULL,
    description text,
    money_need integer,
    money_has integer,
    days_left integer,
    history text,
    video_link text,
    question text
);


CREATE SEQUENCE projects_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE projects_id_seq OWNED BY projects.id;

ALTER TABLE ONLY categories ALTER COLUMN id SET DEFAULT nextval('categories_id_seq'::regclass);

ALTER TABLE ONLY projects ALTER COLUMN id SET DEFAULT nextval('projects_id_seq'::regclass);

INSERT INTO categories (name) VALUES ('Sport'), ('Science'), ('Music');

INSERT INTO projects (category_id, name, description, money_need, money_has, days_left, history, video_link, question) VALUES (3, 'Band', 'We want to create new music band', 15000, 12540, 35, 'bla-bla-bla', 'youtube.com', 'Q: Have you invested your money? A: yes'),
(1, 'Swiming team', 'We need sponsor', 5000, 540, 65, 'bla-bla-bla', 'youtube.com', 'Q: Have you invested your money? A: yes'),
(1, 'Baseball team', 'We need sponsor', 1420, 450, 72, 'bla-bla-bla', 'youtube.com', 'Q: Have you invested your money? A: yes'),
(1, 'Strong man competitions', 'We need money to hold our region competitions', 1000, 540, 15, 'bla-bla-bla', 'youtube.com', 'Q: Have you invested your money? A: yes'),
(2, 'Space Warning', 'Discover the univerce', 156540, 125140, 42, 'bla-bla-bla', 'youtube.com', 'Q: Have you invested your money? A: yes'),
(2, 'World hitting', 'problems with hot sea', 56120, 12100, 121, 'bla-bla-bla', 'youtube.com', NULL);

ALTER TABLE ONLY categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);

ALTER TABLE ONLY projects
    ADD CONSTRAINT projects_pkey PRIMARY KEY (id);

ALTER TABLE ONLY projects
    ADD CONSTRAINT projects_category_id_fkey FOREIGN KEY (category_id) REFERENCES categories(id);

