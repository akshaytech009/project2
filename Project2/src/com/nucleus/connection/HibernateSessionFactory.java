package com.nucleus.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateSessionFactory {
	
			static SessionFactory sf=null;
	public static SessionFactory getConnection(){


		sf=new AnnotationConfiguration().configure().buildSessionFactory();
		return sf;
	}
	

}
