CREATE TABLE categories
(
  name text NOT NULL,
  id bigserial NOT NULL,
  CONSTRAINT categories_pkey PRIMARY KEY (id)
)
  
CREATE TABLE donation
(
  id_donator integer NOT NULL,
  id_project integer NOT NULL,
  amount integer NOT NULL,
  id bigserial NOT NULL,
  CONSTRAINT donation_pkey PRIMARY KEY (id),
  CONSTRAINT donation_id_donator_fkey FOREIGN KEY (id_donator)
      REFERENCES donator (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

CREATE TABLE donator
(
  id bigserial NOT NULL,
  mail text NOT NULL,
  name text NOT NULL,
  card bigint,
  CONSTRAINT donator_pkey PRIMARY KEY (id)
)

CREATE TABLE projects
(
  id_category integer NOT NULL,
  name text NOT NULL,
  short_description text NOT NULL,
  full_description text,
  foto text,
  link text,
  how_much_needed integer NOT NULL,
  how_much_collected integer,
  how_much_remaining integer,
  date_close date NOT NULL,
  id bigserial NOT NULL,
  CONSTRAINT projects_pkey PRIMARY KEY (id),
  CONSTRAINT projects_id_category_fkey FOREIGN KEY (id_category)
      REFERENCES categories (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

CREATE TABLE questions
(
  id bigint NOT NULL DEFAULT nextval('question_id_seq'::regclass),
  id_project integer NOT NULL,
  question text NOT NULL,
  answer text,
  CONSTRAINT question_pkey PRIMARY KEY (id),
  CONSTRAINT question_id_project_fkey FOREIGN KEY (id_project)
      REFERENCES projects (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)