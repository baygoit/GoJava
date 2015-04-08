CREATE TABLE quotes (
    id bigint NOT NULL,
    main_quote text,
    author text
);


ALTER TABLE quotes OWNER TO postgres;


CREATE SEQUENCE quotes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE quotes_id_seq OWNER TO postgres;

ALTER SEQUENCE quotes_id_seq OWNED BY quotes.id;

ALTER TABLE ONLY quotes ALTER COLUMN id SET DEFAULT nextval('quotes_id_seq'::regclass);

ALTER TABLE ONLY quotes
    ADD CONSTRAINT quotes_pkey PRIMARY KEY (id);
    
INSERT INTO quotes (main_quote, author) VALUES ('If you don''t know where you''re going, you will probably end up somewhere else', 'Laurence J. Peter');
INSERT INTO quotes (main_quote, author) VALUES ('Never confuse a single defeat with a final defeat', 'F. Scott Fitzgerald');
INSERT INTO quotes (main_quote, author) VALUES ('You have to learn the rules of the game. And then you have to play better than anyone else', 'Albert Einstein');
INSERT INTO quotes (main_quote, author) VALUES ('I want the world to be better because I was here', 'Will Smith');