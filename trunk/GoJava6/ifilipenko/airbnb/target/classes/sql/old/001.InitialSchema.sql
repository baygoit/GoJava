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
-- Name: countries; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE countries (
    id integer NOT NULL,
	code character varying(64) NOT NULL,
	name character varying(255),
	modifiedon timestamp without time zone DEFAULT (now() at time zone 'utc') NOT NULL,
    createdon timestamp without time zone DEFAULT (now() at time zone 'utc') NOT NULL
);

ALTER TABLE countries OWNER TO postgres;

--
-- Name: Countries_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Countries_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Countries_Id_seq" OWNER TO postgres;

--
-- Name: Countries_Id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Countries_Id_seq" OWNED BY countries.id;

--
-- Name: cities; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cities (
    id integer NOT NULL,
	code character varying(64) NOT NULL,
	name character varying(255),
	country_id integer NOT NULL,
	modifiedon timestamp without time zone DEFAULT (now() at time zone 'utc') NOT NULL,
    createdon timestamp without time zone DEFAULT (now() at time zone 'utc') NOT NULL
);

ALTER TABLE cities OWNER TO postgres;

--
-- Name: Cities_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Cities_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Cities_Id_seq" OWNER TO postgres;

--
-- Name: Cities_Id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Cities_Id_seq" OWNED BY cities.id;

--
-- Name: genders; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE genders (
    id integer NOT NULL,
	code character varying(64) NOT NULL,
	name character varying(255),
	modifiedon timestamp without time zone DEFAULT (now() at time zone 'utc') NOT NULL,
    createdon timestamp without time zone DEFAULT (now() at time zone 'utc') NOT NULL
);

ALTER TABLE genders OWNER TO postgres;

--
-- Name: Genders_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Genders_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Genders_Id_seq" OWNER TO postgres;

--
-- Name: Genders_Id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Genders_Id_seq" OWNED BY genders.id;


--
-- Name: hometypes; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--
CREATE TABLE hometypes (
    id integer NOT NULL,
	code character varying(64) NOT NULL,
	name character varying(255),
	modifiedon timestamp without time zone DEFAULT (now() at time zone 'utc') NOT NULL,
    createdon timestamp without time zone DEFAULT (now() at time zone 'utc') NOT NULL
);

ALTER TABLE hometypes OWNER TO postgres;

--
-- Name: HomeTypes_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--
CREATE SEQUENCE "HomeTypes_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "HomeTypes_Id_seq" OWNER TO postgres;

--
-- Name: HomeTypes_Id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--
ALTER SEQUENCE "HomeTypes_Id_seq" OWNED BY hometypes.id;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--
CREATE TABLE users (
    id integer NOT NULL,
	firstname character varying(255),
	lastname character varying(255),
	emailaddress character varying(255),
	gender_id integer NOT NULL,
	city_id integer NOT NULL,
	birthdate character varying(255),
    password bytea,
    passwordsalt bytea,
    lastloginon timestamp without time zone,
	active boolean DEFAULT true NOT NULL,
	modifiedon timestamp without time zone DEFAULT (now() at time zone 'utc') NOT NULL,
    createdon timestamp without time zone DEFAULT (now() at time zone 'utc') NOT NULL
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
    user_id integer NOT NULL,
    city_id integer NOT NULL,
	hometype_id integer NOT NULL,
	active boolean DEFAULT true NOT NULL,
	modifiedon timestamp without time zone DEFAULT (now() at time zone 'utc') NOT NULL,
    createdon timestamp without time zone DEFAULT (now() at time zone 'utc') NOT NULL
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
	endatedate timestamp without time zone,
	comment character varying(500),
	active boolean DEFAULT true NOT NULL,
	modifiedon timestamp without time zone DEFAULT (now() at time zone 'utc') NOT NULL,
    createdon timestamp without time zone DEFAULT (now() at time zone 'utc') NOT NULL
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
ALTER TABLE ONLY countries ALTER COLUMN id SET DEFAULT nextval('"Countries_Id_seq"'::regclass);
ALTER TABLE ONLY cities ALTER COLUMN id SET DEFAULT nextval('"Cities_Id_seq"'::regclass);
ALTER TABLE ONLY genders ALTER COLUMN id SET DEFAULT nextval('"Genders_Id_seq"'::regclass);
ALTER TABLE ONLY hometypes ALTER COLUMN id SET DEFAULT nextval('"HomeTypes_Id_seq"'::regclass);
ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('"Users_Id_seq"'::regclass);
ALTER TABLE ONLY homes ALTER COLUMN id SET DEFAULT nextval('"Homes_Id_seq"'::regclass);
ALTER TABLE ONLY reservations ALTER COLUMN id SET DEFAULT nextval('"Reservations_Id_seq"'::regclass);

--Type: PK CONSTRAINT; Schema: public; Owner: postgres
--
ALTER TABLE ONLY countries ADD CONSTRAINT "PK_Countries" PRIMARY KEY (id);
ALTER TABLE ONLY cities ADD CONSTRAINT "PK_Cities" PRIMARY KEY (id);
ALTER TABLE ONLY genders ADD CONSTRAINT "PK_Genders" PRIMARY KEY (id);
ALTER TABLE ONLY hometypes ADD CONSTRAINT "PK_HomeTypes" PRIMARY KEY (id);
ALTER TABLE ONLY users ADD CONSTRAINT "PK_Users" PRIMARY KEY (id);
ALTER TABLE ONLY homes ADD CONSTRAINT "PK_Homes" PRIMARY KEY (id);
ALTER TABLE ONLY reservations ADD CONSTRAINT "PK_Reservations" PRIMARY KEY (id);

-- Name: ; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--
ALTER TABLE ONLY countries ADD CONSTRAINT "UQ_Countries_Code" UNIQUE (code);
ALTER TABLE ONLY cities ADD CONSTRAINT "UQ_Cities_Code" UNIQUE (code);
ALTER TABLE ONLY genders ADD CONSTRAINT "UQ_Genders_Code" UNIQUE (code);
ALTER TABLE ONLY hometypes ADD CONSTRAINT "UQ_HomeTypes_Code" UNIQUE (code);
ALTER TABLE ONLY users ADD CONSTRAINT "UQ_Users_GenderId_CityId" UNIQUE (gender_id, city_id);
ALTER TABLE ONLY homes ADD CONSTRAINT "UQ_Cities_UserId_CityId_HomeTypeId" UNIQUE (user_id, city_id, hometype_id);
ALTER TABLE ONLY reservations ADD CONSTRAINT "UQ_Reservations_UserId_HomeId" UNIQUE (user_id, home_id);


-- Name: FK_Warnings_ModifiedById; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--
ALTER TABLE ONLY cities ADD CONSTRAINT "FK_Cities_CountryId" FOREIGN KEY (country_id) REFERENCES countries(id) ON DELETE CASCADE;
ALTER TABLE ONLY users ADD CONSTRAINT "FK_Users_CityId" FOREIGN KEY (city_id) REFERENCES cities(id) ON DELETE CASCADE;
ALTER TABLE ONLY users ADD CONSTRAINT "FK_Users_GenderId" FOREIGN KEY (gender_id) REFERENCES genders(id) ON DELETE CASCADE;
ALTER TABLE ONLY homes ADD CONSTRAINT "FK_Homes_UserId" FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;
ALTER TABLE ONLY homes ADD CONSTRAINT "FK_Homes_CityId" FOREIGN KEY (city_id) REFERENCES cities(id) ON DELETE CASCADE;
ALTER TABLE ONLY homes ADD CONSTRAINT "FK_Homes_HomeTypeId" FOREIGN KEY (hometype_id) REFERENCES hometypes(id) ON DELETE CASCADE;
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


