package com.doglab.form.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("cadastros");
	
	public static EntityManager getEntityManager()
	{
		return factory.createEntityManager();
	}
	
}
