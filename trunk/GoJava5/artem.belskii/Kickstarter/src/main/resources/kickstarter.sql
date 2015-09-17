--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'WIN1251';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: categoryes; Type: TABLE; Schema: public; Owner: root; Tablespace: 
--

CREATE TABLE categoryes (
    id integer NOT NULL,
    title character varying(100)
);


ALTER TABLE categoryes OWNER TO root;

--
-- Name: categoryes_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE categoryes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE categoryes_id_seq OWNER TO root;

--
-- Name: categoryes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE categoryes_id_seq OWNED BY categoryes.id;


--
-- Name: faq; Type: TABLE; Schema: public; Owner: root; Tablespace: 
--

CREATE TABLE faq (
    id integer NOT NULL,
    project_id numeric,
    question character varying(1000),
    answer character varying(1000)
);


ALTER TABLE faq OWNER TO root;

--
-- Name: faq_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE faq_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE faq_id_seq OWNER TO root;

--
-- Name: faq_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE faq_id_seq OWNED BY faq.id;


--
-- Name: payment_methods; Type: TABLE; Schema: public; Owner: root; Tablespace: 
--

CREATE TABLE payment_methods (
    id integer NOT NULL,
    project_id numeric,
    payment_amoumt numeric,
    bonus character varying(1000)
);


ALTER TABLE payment_methods OWNER TO root;

--
-- Name: payment_methods_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE payment_methods_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE payment_methods_id_seq OWNER TO root;

--
-- Name: payment_methods_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE payment_methods_id_seq OWNED BY payment_methods.id;


--
-- Name: projects; Type: TABLE; Schema: public; Owner: root; Tablespace: 
--

CREATE TABLE projects (
    id integer NOT NULL,
    project_name character varying(100),
    goal numeric,
    balance numeric,
    start_date character varying(20),
    end_date character varying(20),
    video_url character varying(500),
    category_id numeric,
    details character varying(1000)
);


ALTER TABLE projects OWNER TO root;

--
-- Name: projects_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE projects_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE projects_id_seq OWNER TO root;

--
-- Name: projects_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE projects_id_seq OWNED BY projects.id;


--
-- Name: quotes; Type: TABLE; Schema: public; Owner: root; Tablespace: 
--

CREATE TABLE quotes (
    id integer NOT NULL,
    text character varying(500)
);


ALTER TABLE quotes OWNER TO root;

--
-- Name: quotes_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE quotes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE quotes_id_seq OWNER TO root;

--
-- Name: quotes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE quotes_id_seq OWNED BY quotes.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY categoryes ALTER COLUMN id SET DEFAULT nextval('categoryes_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY faq ALTER COLUMN id SET DEFAULT nextval('faq_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY payment_methods ALTER COLUMN id SET DEFAULT nextval('payment_methods_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY projects ALTER COLUMN id SET DEFAULT nextval('projects_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY quotes ALTER COLUMN id SET DEFAULT nextval('quotes_id_seq'::regclass);


--
-- Data for Name: categoryes; Type: TABLE DATA; Schema: public; Owner: root
--

COPY categoryes (id, title) FROM stdin;
1	Art
2	Comics
3	Crafts
4	Dance
5	Design
6	Fashion
7	Film & Video
8	Food
9	Games
10	Journalism
11	Music
12	Photography
13	Publishing
14	Technology
15	Theater
\.


--
-- Name: categoryes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('categoryes_id_seq', 15, true);


--
-- Data for Name: faq; Type: TABLE DATA; Schema: public; Owner: root
--

COPY faq (id, project_id, question, answer) FROM stdin;
\.


--
-- Name: faq_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('faq_id_seq', 1, false);


--
-- Data for Name: payment_methods; Type: TABLE DATA; Schema: public; Owner: root
--

COPY payment_methods (id, project_id, payment_amoumt, bonus) FROM stdin;
\.


--
-- Name: payment_methods_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('payment_methods_id_seq', 1, false);


--
-- Data for Name: projects; Type: TABLE DATA; Schema: public; Owner: root
--

COPY projects (id, project_name, goal, balance, start_date, end_date, video_url, category_id, details) FROM stdin;
2	My test project1 from Comics category	2	2	29.07.2015	31.07.2015	https://www.youtube.com/watch?v=uC0pqWX3yB8	2	Project details
3	My test project2 from Crafts category	3	3	30.07.2015	01.08.2015	https://www.youtube.com/watch?v=uC0pqWX3yB8	3	Project details
4	My test project from Art category	1	1	28.07.2015	30.07.2015	https://www.youtube.com/watch?v=uC0pqWX3yB8	1	Project details
5	My test project1 from Comics category	2	2	29.07.2015	31.07.2015	https://www.youtube.com/watch?v=uC0pqWX3yB8	2	Project details
6	My test project2 from Crafts category	3	3	30.07.2015	01.08.2015	https://www.youtube.com/watch?v=uC0pqWX3yB8	3	Project details
1	New Name	1	1	28.07.2015	30.07.2015	https://www.youtube.com/watch?v=uC0pqWX3yB8	1	Project details
\.


--
-- Name: projects_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('projects_id_seq', 6, true);


--
-- Data for Name: quotes; Type: TABLE DATA; Schema: public; Owner: root
--

COPY quotes (id, text) FROM stdin;
1	Things work out best for those who make the best of how things work out.
2	All our dreams can come true if we have the courage to pursue them.
3	Success is walking from failure to failure with no loss of enthusiasm.
4	Try not to become a person of success, but rather try to become a person of value.
5	Don't be afraid to give up the good to go for the great.
\.


--
-- Name: quotes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('quotes_id_seq', 5, true);


--
-- Name: public; Type: ACL; Schema: -; Owner: root
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM root;
GRANT ALL ON SCHEMA public TO root;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'WIN1251';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: categoryes; Type: TABLE; Schema: public; Owner: root; Tablespace: 
--

CREATE TABLE categoryes (
    id integer NOT NULL,
    title character varying(100)
);


ALTER TABLE categoryes OWNER TO root;

--
-- Name: categoryes_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE categoryes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE categoryes_id_seq OWNER TO root;

--
-- Name: categoryes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE categoryes_id_seq OWNED BY categoryes.id;


--
-- Name: faq; Type: TABLE; Schema: public; Owner: root; Tablespace: 
--

CREATE TABLE faq (
    id integer NOT NULL,
    project_id numeric,
    question character varying(1000),
    answer character varying(1000)
);


ALTER TABLE faq OWNER TO root;

--
-- Name: faq_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE faq_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE faq_id_seq OWNER TO root;

--
-- Name: faq_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE faq_id_seq OWNED BY faq.id;


--
-- Name: payment_methods; Type: TABLE; Schema: public; Owner: root; Tablespace: 
--

CREATE TABLE payment_methods (
    id integer NOT NULL,
    project_id numeric,
    payment_amoumt numeric,
    bonus character varying(1000)
);


ALTER TABLE payment_methods OWNER TO root;

--
-- Name: payment_methods_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE payment_methods_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE payment_methods_id_seq OWNER TO root;

--
-- Name: payment_methods_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE payment_methods_id_seq OWNED BY payment_methods.id;


--
-- Name: projects; Type: TABLE; Schema: public; Owner: root; Tablespace: 
--

CREATE TABLE projects (
    id integer NOT NULL,
    project_name character varying(100),
    goal numeric,
    balance numeric,
    start_date character varying(20),
    end_date character varying(20),
    video_url character varying(500),
    category_id numeric,
    details character varying(1000)
);


ALTER TABLE projects OWNER TO root;

--
-- Name: projects_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE projects_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE projects_id_seq OWNER TO root;

--
-- Name: projects_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE projects_id_seq OWNED BY projects.id;


--
-- Name: quotes; Type: TABLE; Schema: public; Owner: root; Tablespace: 
--

CREATE TABLE quotes (
    id integer NOT NULL,
    text character varying(500)
);


ALTER TABLE quotes OWNER TO root;

--
-- Name: quotes_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE quotes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE quotes_id_seq OWNER TO root;

--
-- Name: quotes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE quotes_id_seq OWNED BY quotes.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY categoryes ALTER COLUMN id SET DEFAULT nextval('categoryes_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY faq ALTER COLUMN id SET DEFAULT nextval('faq_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY payment_methods ALTER COLUMN id SET DEFAULT nextval('payment_methods_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY projects ALTER COLUMN id SET DEFAULT nextval('projects_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY quotes ALTER COLUMN id SET DEFAULT nextval('quotes_id_seq'::regclass);


--
-- Data for Name: categoryes; Type: TABLE DATA; Schema: public; Owner: root
--

COPY categoryes (id, title) FROM stdin;
1	Art
2	Comics
3	Crafts
4	Dance
5	Design
6	Fashion
7	Film & Video
8	Food
9	Games
10	Journalism
11	Music
12	Photography
13	Publishing
14	Technology
15	Theater
\.


--
-- Name: categoryes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('categoryes_id_seq', 15, true);


--
-- Data for Name: faq; Type: TABLE DATA; Schema: public; Owner: root
--

COPY faq (id, project_id, question, answer) FROM stdin;
1	1	question from web page	not answered yet
\.


--
-- Name: faq_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('faq_id_seq', 1, true);


--
-- Data for Name: payment_methods; Type: TABLE DATA; Schema: public; Owner: root
--

COPY payment_methods (id, project_id, payment_amoumt, bonus) FROM stdin;
\.


--
-- Name: payment_methods_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('payment_methods_id_seq', 1, false);


--
-- Data for Name: projects; Type: TABLE DATA; Schema: public; Owner: root
--

COPY projects (id, project_name, goal, balance, start_date, end_date, video_url, category_id, details) FROM stdin;
2	project 2	2	2	29.07.2015	31.07.2015	https://www.youtube.com/watch?v=uC0pqWX3yB8	2	Project details
3	project 3	3	3	30.07.2015	01.08.2015	https://www.youtube.com/watch?v=uC0pqWX3yB8	3	Project details
4	project 4	1	1	28.07.2015	30.07.2015	https://www.youtube.com/watch?v=uC0pqWX3yB8	1	Project details
5	project 5	2	2	29.07.2015	31.07.2015	https://www.youtube.com/watch?v=uC0pqWX3yB8	2	Project details
6	project 6	3	3	30.07.2015	01.08.2015	https://www.youtube.com/watch?v=uC0pqWX3yB8	3	Project details
1	project 1	1	1	28.07.2015	30.07.2015	https://www.youtube.com/watch?v=uC0pqWX3yB8	1	Project details
\.


--
-- Name: projects_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('projects_id_seq', 6, true);


--
-- Data for Name: quotes; Type: TABLE DATA; Schema: public; Owner: root
--

COPY quotes (id, text) FROM stdin;
1	Things work out best for those who make the best of how things work out.
2	All our dreams can come true if we have the courage to pursue them.
3	Success is walking from failure to failure with no loss of enthusiasm.
4	Try not to become a person of success, but rather try to become a person of value.
5	Don't be afraid to give up the good to go for the great.
6	Things work out best for those who make the best of how things work out.
7	All our dreams can come true if we have the courage to pursue them.
8	Success is walking from failure to failure with no loss of enthusiasm.
9	Try not to become a person of success, but rather try to become a person of value.
10	Don't be afraid to give up the good to go for the great.
11	Things work out best for those who make the best of how things work out.
12	All our dreams can come true if we have the courage to pursue them.
13	Success is walking from failure to failure with no loss of enthusiasm.
14	Try not to become a person of success, but rather try to become a person of value.
15	Don't be afraid to give up the good to go for the great.
\.


--
-- Name: quotes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('quotes_id_seq', 15, true);


--
-- Name: public; Type: ACL; Schema: -; Owner: root
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM root;
GRANT ALL ON SCHEMA public TO root;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

