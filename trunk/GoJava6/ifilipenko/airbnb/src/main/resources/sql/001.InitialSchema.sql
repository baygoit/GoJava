--
-- PostgreSQL database dump
--
SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 444 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 4388 (class 0 OID 0)
-- Dependencies: 444
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--
CREATE TABLE users (
    id integer NOT NULL,
	firstname character varying(255),
	lastname character varying(255),
	emailaddress character varying(255),
	gender character varying(64),
	birthdate timestamp without time zone,
	city character varying(255)
);

ALTER TABLE users OWNER TO postgres;

--
-- Name: Users_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--
CREATE SEQUENCE "Users_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Users_Id_seq" OWNER TO postgres;

--
-- Name: Users_Id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--
ALTER SEQUENCE "Users_Id_seq" OWNED BY users.id;
--
-- Name: homes; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--
CREATE TABLE homes (
    id integer NOT NULL,
    host_id integer NOT NULL,
    city character varying(255),
	hometype character varying(255)
);

ALTER TABLE homes OWNER TO postgres;

--
-- Name: Homes_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--
CREATE SEQUENCE "Homes_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Homes_Id_seq" OWNER TO postgres;

--
-- Name: Homes_Id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--
ALTER SEQUENCE "Homes_Id_seq" OWNED BY homes.id;

--
-- Name: reservations; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--
CREATE TABLE reservations (
    id integer NOT NULL,
    user_id integer NOT NULL,
    home_id integer NOT NULL,
	startdate timestamp without time zone,
	endatedate timestamp without time zone
);

ALTER TABLE reservations OWNER TO postgres;

--
-- Name: Reservations_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--
CREATE SEQUENCE "Reservations_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Reservations_Id_seq" OWNER TO postgres;

--
-- Name: Reservations_Id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--
ALTER SEQUENCE "Reservations_Id_seq" OWNED BY reservations.id;


-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--
ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('"Users_Id_seq"'::regclass);
ALTER TABLE ONLY homes ALTER COLUMN id SET DEFAULT nextval('"Homes_Id_seq"'::regclass);
ALTER TABLE ONLY reservations ALTER COLUMN id SET DEFAULT nextval('"Reservations_Id_seq"'::regclass);

--Type: PK CONSTRAINT; Schema: public; Owner: postgres
--
ALTER TABLE ONLY users ADD CONSTRAINT "PK_Users" PRIMARY KEY (id);
ALTER TABLE ONLY homes ADD CONSTRAINT "PK_Homes" PRIMARY KEY (id);
ALTER TABLE ONLY reservations ADD CONSTRAINT "PK_Reservations" PRIMARY KEY (id);

-- Name: ; Type: UNIQUE CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--
ALTER TABLE ONLY homes ADD CONSTRAINT "UQ_Cities_UserId" UNIQUE (host_id);
ALTER TABLE ONLY reservations ADD CONSTRAINT "UQ_Reservations_UserId_HomeId" UNIQUE (user_id, home_id);


-- Name: ; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--
ALTER TABLE ONLY homes ADD CONSTRAINT "FK_Homes_UserId" FOREIGN KEY (host_id) REFERENCES users(id) ON DELETE CASCADE;
ALTER TABLE ONLY reservations ADD CONSTRAINT "FK_Reservations_UserId" FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;
ALTER TABLE ONLY reservations ADD CONSTRAINT "FK_Reservations_HomeId" FOREIGN KEY (home_id) REFERENCES homes(id) ON DELETE CASCADE;

-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;

--
-- PostgreSQL database dump complete
--


