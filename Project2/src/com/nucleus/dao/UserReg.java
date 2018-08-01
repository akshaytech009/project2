package com.nucleus.dao;

import java.util.*;

import com.nucleus.model.Customer;
import com.nucleus.model.User;

public interface UserReg {

	boolean insert(User user);

	boolean validate(String userid, String userpass, String role);

	boolean addUser(Customer cust);

	Customer validateuser(String customercode);

	List<Customer> validateAllUser();

	Customer validateupdate(String customercode);

	boolean updateCustomer(Customer cust);

	boolean deleteCustomer(String customercode);

}
