package com.suraj.springDemo.dao;

import java.util.List;

import com.suraj.springDemo.entity.Customer;


public interface CustomerDao {

	public List<Customer> getCustomer();

	public void saveCustomer(Customer thecustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String thesearchname);
	
	
}
