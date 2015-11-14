
--
-- Name: countries; Type: INSERT; Schema: public; Owner: postgres
--
INSERT INTO countries(code, name) VALUES ('USA', 'United States of America');
INSERT INTO countries(code, name) VALUES ('UKR', 'Ukraine');
INSERT INTO countries(code, name) VALUES ('ITA', 'Italy');

--
-- Name: cities; Type: INSERT; Schema: public; Owner: postgres
--
INSERT INTO cities(code, name, country_id) VALUES(1, 'Los Angeles', (SELECT id FROM countries WHERE code = 'USA') );
INSERT INTO cities(code, name, country_id) VALUES(2, 'Kyiv', (SELECT id FROM countries WHERE code = 'UKR') );
INSERT INTO cities(code, name, country_id) VALUES(3, 'Venice', (SELECT id FROM countries WHERE code = 'ITA') );

--
-- Name: genders; Type: INSERT; Schema: public; Owner: postgres
--
INSERT INTO genders(code, name) VALUES ('1', 'Female');
INSERT INTO genders(code, name) VALUES ('2', 'Male');

--
-- Name: hometypes; Type: INSERT; Schema: public; Owner: postgres
--
INSERT INTO hometypes(code, name) VALUES ('1', 'Apartment');
INSERT INTO hometypes(code, name) VALUES ('2', 'Room');
INSERT INTO hometypes(code, name) VALUES ('3', 'House');

--
-- Name: users; Type: INSERT; Schema: public; Owner: postgres
--
INSERT INTO users(
            firstname, lastname, emailaddress, 
            gender_id, 
            city_id, 
            birthdate, active)
 	VALUES ('Inna', 'Filipenko','innaf@gmail.com', 
			(SELECT id FROM genders WHERE code = '1'), 
			(SELECT id FROM cities WHERE code = '2'),
			'1971-07-13', true);

 --
-- Name: homes; Type: INSERT; Schema: public; Owner: postgres
--
INSERT INTO homes(
            user_id, 
            city_id, 
            hometype_id, 
            active)
    VALUES ((SELECT id FROM users where emailaddress = 'innaf@gmail.com')
	    ,(SELECT id FROM cities where name = 'Kyiv')
	    ,(SELECT id FROM hometypes where code = '1')
	    ,true);