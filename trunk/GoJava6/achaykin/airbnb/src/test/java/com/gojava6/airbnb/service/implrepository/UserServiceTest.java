package com.gojava6.airbnb.service.implrepository;

import com.gojava6.airbnb.UtilUser;
import com.gojava6.airbnb.config.DataConfigTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfigTest.class)
@WebAppConfiguration

public class UserServiceTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private UserService userServices;


    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();

    }

    @Test
    public void testSaveBank() throws Exception {
        userServices.create(UtilUser.createUser());
    }
}
