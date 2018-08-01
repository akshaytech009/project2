package com.nucleus.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nucleus.model.Customer;
import com.nucleus.model.User;

public class UserRegImpl implements UserReg {

	SessionFactory sf = null;

	public UserRegImpl(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public boolean insert(User user) {
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();
		boolean isUserAdded = false;

		try {
			tx.begin();
			session.save(user);
			tx.commit();
			isUserAdded = true;
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return isUserAdded;

	}

	public boolean validate(String userid, String userpass, String role) {

		Session session = sf.openSession();
		session.getTransaction().begin();
		Query query = null;
		try {
			query = session
					.createQuery("select u from User u where username=:name , userpass=:pass , role=:"+role);
			
			query.setParameter("name", userid);
			query.setParameter("pass", userpass);
			
			List<User> user = query.list();
			if (!user.isEmpty()) {
				
				return true;
			} else
				return false;
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	public boolean addUser(Customer customer) {
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();
		boolean isCustomerAdded = false;

		try {
			tx.begin();
			session.save(customer);
			tx.commit();
			isCustomerAdded = true;
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return isCustomerAdded;

	}

	public Customer validateuser(String customercode) {
		Session session = sf.openSession();
		session.getTransaction().begin();
		Query query = null;
		try {
			query = session
					.createQuery("select c from Customer c where c.customerCode=:name");
			query.setParameter("name", customercode);

			List<Customer> customer = query.list();
			if (!customer.isEmpty()) {

				return customer.get(0);
			} else
				return null;
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	@Override
	public List<Customer> validateAllUser() {
		Session session = sf.openSession();
		session.getTransaction().begin();
		try {
			Query query = session.createQuery("from Customer");
			List<Customer> list = query.list();

			if (!list.isEmpty()) {

				return list;
			} else
				return null;

		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	@Override
	public Customer validateupdate(String customercode) {

		Session session = sf.openSession();
		session.getTransaction().begin();
		Query query = null;
		try {
			query = session
					.createQuery("select c from Customer c where c.customerCode=:name");
			query.setParameter("name", customercode);

			List<Customer> customer = query.list();
			if (!customer.isEmpty()) {

				return customer.get(0);
			} else
				return null;
		} finally {
			session.getTransaction().commit();
			session.close();
		}

	}

	public boolean updateCustomer(Customer customer) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session
				.createQuery("update Customer c set c.customerName=:customerName, c.customerAddress1=:customerAddress1, c.customerAddress2=:customerAddress2, c.customerPinCode=:customerPinCode, c.emailAddress=:emailAddress, c.contactNumber=:contactNumber, c.primaryContactPerson=:primaryContactPerson, c.recordStatus=:recordStatus, c.activeInactiveFlag=:activeInactiveFlag, c.createDate=:createDate, c.createdBy=:createdBy, c.modifiedDate=:modifiedDate, c.modifiedBy=:modifiedBy, c.authorisedDate=:authorisedDate, c.authorisedBy=:authorisedBy where c.customerCode=:customerCode");

		query.setParameter("customerName", customer.getCustomerName());
		query.setParameter("customerAddress1", customer.getCustomerAddress1());
		query.setParameter("customerAddress2", customer.getCustomerAddress2());
		query.setParameter("customerPinCode", customer.getCustomerPinCode());
		query.setParameter("emailAddress", customer.getEmailAddress());
		query.setParameter("contactNumber", customer.getContactNumber());
		query.setParameter("primaryContactPerson",
				customer.getPrimaryContactPerson());
		query.setParameter("recordStatus", customer.getRecordStatus());
		query.setParameter("activeInactiveFlag",
				customer.getActiveInactiveFlag());
		query.setParameter("createDate", customer.getCreateDate());
		query.setParameter("createdBy", customer.getCreatedBy());
		query.setParameter("modifiedDate", customer.getModifiedDate());
		query.setParameter("modifiedBy", customer.getModifiedBy());
		query.setParameter("authorisedDate", customer.getAuthorisedDate());
		query.setParameter("authorisedBy", customer.getAuthorisedBy());

		query.setParameter("customerCode", customer.getCustomerCode());

		int result = query.executeUpdate();
		tx.commit();
		if (result > 0) {
			return true;
		} else
			return false;
	}

	public boolean deleteCustomer(String customerCode) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session
				.createQuery("delete Customer c where c.customerCode=:code");
		query.setParameter("code", customerCode);
		int result = query.executeUpdate();
		tx.commit();
		if (result > 0) {
			return true;
		} else
			return false;
	}

}
