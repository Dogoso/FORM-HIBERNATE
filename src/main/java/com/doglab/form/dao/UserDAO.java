package com.doglab.form.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.doglab.form.users.User;

public class UserDAO {

	private EntityManager em;
	
	public UserDAO(EntityManager em) 
	{
		this.em = em;	
	}
	
	public void createUser(User user) 
	{
		em.persist(user);
	}

	public List<User> readUsers() 
	{	
		String JPQL = "SELECT u FROM User AS u";
		return em.createQuery(JPQL, User.class)
				.getResultList();
	}
	
	public User readUniqueUser(User user) 
	{
		String JPQL = "SELECT u FROM User AS u WHERE u.email = :email";
		User dbUser = null;
		
		try 
		{
			dbUser = em.createQuery(JPQL, User.class)
					.setParameter("email", user.getEmail())
					.getSingleResult();
		}catch(NoResultException nre)
		{
			return null;
		}
		
		return dbUser;
	}
	
}
