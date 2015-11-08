CREATE TABLE app.categories
(
  id SERIAL PRIMARY KEY,
  name text UNIQUE
);
ALTER TABLE app.categories
  OWNER TO "Kickstarter";

 CREATE TABLE app.quotes
(
  id SERIAL PRIMARY KEY,
  text text,
  author text
);
ALTER TABLE app.quotes
  OWNER TO "Kickstarter";

CREATE TABLE app.projects
(
  id serial NOT NULL,
  name text NOT NULL,
  description text,
  amount_goal integer,
  amount_pledged integer,
  deadline date,
  category_id bigint,
  link_to_video text,
  CONSTRAINT pk PRIMARY KEY (id),
  CONSTRAINT fk FOREIGN KEY (category_id)
      REFERENCES app.categories (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
ALTER TABLE app.projects
  OWNER TO "Kickstarter";   

 CREATE TABLE app.faqs
(
  id serial NOT NULL,
  question text NOT NULL,
  answer text,
  project_id bigint,
  CONSTRAINT faq_pk PRIMARY KEY (id),
  CONSTRAINT faq_fk FOREIGN KEY (project_id)
      REFERENCES app.projects (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
ALTER TABLE app.faqs
  OWNER TO "Kickstarter";

CREATE TABLE app.events
(
  id serial NOT NULL,
  description text NOT NULL,
  event_date date NOT NULL,
  project_id bigint,
  CONSTRAINT event_pk PRIMARY KEY (id),
  CONSTRAINT event_fk FOREIGN KEY (project_id)
      REFERENCES app.projects (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
ALTER TABLE app.events
  OWNER TO "Kickstarter";

CREATE TABLE app.reward_options
(
  id serial NOT NULL,
  amount integer NOT NULL,
  description text NOT NULL,
  project_id bigint,
  CONSTRAINT reward_pk PRIMARY KEY (id),
  CONSTRAINT reward_fk FOREIGN KEY (project_id)
      REFERENCES app.projects (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
ALTER TABLE app.reward_options
  OWNER TO "Kickstarter";     