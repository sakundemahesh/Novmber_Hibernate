package com.hibernate.config;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Product;

public class HibernateConfig{

	public static SessionFactory getSessionFactory() {
		Configuration configuration=new Configuration();
		configuration.configure().addAnnotatedClass(Product.class);
		
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		return sessionFactory ;
		
	}
}
