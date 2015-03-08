-- Table: categories

-- DROP TABLE categories;

CREATE TABLE categories
(
  id_category bigserial NOT NULL,
  name_category text NOT NULL,
  description_category text,
  CONSTRAINT categories_pkey PRIMARY KEY (id_category)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE categories
  OWNER TO postgres;
  
-- Table: projects

-- DROP TABLE projects;

CREATE TABLE projects
(
  id_project bigserial NOT NULL,
  id_category integer NOT NULL,
  name_project text NOT NULL,
  short_description_project text NOT NULL,
  full_description_project text,
  foto_project text,
  link_project text,
  how_much_needed_project integer NOT NULL,
  how_much_collected_project integer NOT NULL,
  how_much_remaining_project integer NOT NULL,
  date_close_project date NOT NULL,
  CONSTRAINT projects_pkey PRIMARY KEY (id_project),
  CONSTRAINT projects_id_category_fkey FOREIGN KEY (id_category)
      REFERENCES categories (id_category) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE projects
  OWNER TO postgres;

  
  
-- Table: quotes

-- DROP TABLE quotes;

CREATE TABLE quotes
(
  id_quote bigserial NOT NULL,
  quote text NOT NULL,
  CONSTRAINT quotes_pkey PRIMARY KEY (id_quote)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE quotes
  OWNER TO postgres;

  
  
  
-- Table: faq

-- DROP TABLE faq;

CREATE TABLE faq
(
  id_project integer NOT NULL,
  question text NOT NULL,
  CONSTRAINT faq_id_project_fkey FOREIGN KEY (id_project)
      REFERENCES projects (id_project) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE faq
  OWNER TO postgres;
  
  
  
