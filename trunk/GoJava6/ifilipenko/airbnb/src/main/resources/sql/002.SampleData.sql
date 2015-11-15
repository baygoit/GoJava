--
-- Name: users; Type: INSERT; Schema: public; Owner: postgres
--
INSERT INTO users(
            firstname, lastname, emailaddress,
            gender,
            city,
            birthdate, active)
 	VALUES ('Inna', 'Filipenko','innaf@gmail.com',
			'Female',
			'Kyiv',
			'1971-07-13', true);

 --
-- Name: homes; Type: INSERT; Schema: public; Owner: postgres
--
INSERT INTO homes(
            user_id,
            city,
            hometype,
            active)
    VALUES ((SELECT id FROM users where emailaddress = 'innaf@gmail.com')
	    ,'Kyiv'
	    ,'Room'
	    ,true);