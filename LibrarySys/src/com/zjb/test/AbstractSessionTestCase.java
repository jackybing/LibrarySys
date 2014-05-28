package com.zjb.test;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Title: AbstractSessionTestCase.java
 */
@RunWith(SpringJUnit4ClassRunner.class)   
@ContextConfiguration({"classpath:springMVC-servlet.xml","classpath:applicationContext.xml"})
public abstract class AbstractSessionTestCase {
    
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    
    @Before
    public void openSession()  throws Exception {
        session = SessionFactoryUtils.getSession(sessionFactory, true);
        session.setFlushMode(FlushMode.MANUAL);
        TransactionSynchronizationManager.bindResource(sessionFactory,new SessionHolder(session));
    }
    
    @After
    public void closeSession()  throws Exception {
        TransactionSynchronizationManager.unbindResource(sessionFactory);
        SessionFactoryUtils.releaseSession(session, sessionFactory);
    }

}
