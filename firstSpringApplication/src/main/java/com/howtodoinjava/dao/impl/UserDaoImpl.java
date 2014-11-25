package com.howtodoinjava.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.howtodoinjava.dao.UserDao;
import com.howtodoinjava.model.User;


@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceUnit(unitName="testspring-jpa-seconde")
    EntityManagerFactory emf;
	
	
	public User getUserDetails(String mail, String pass) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
        String queryStr = "SELECT * FROM user where mail=:mail and password=:pass ";
        Query query = em.createNativeQuery(queryStr, User.class);
        query.setParameter("mail", mail);
        query.setParameter("pass", pass);
        User result = new User();
        try {
            result = (User)query.getSingleResult();
            return result;
        } catch (NoResultException e) {
        	System.out.println("No result forund for... ");
        }
        result.setEmail("");
		return result;
	}

}
