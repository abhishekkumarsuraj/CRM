package com.suraj.springDemo.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suraj.springDemo.dao.CustomerDao;
import com.suraj.springDemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
	List<Customer>	list=customerDao.getCustomer();
	
      Collections.sort(list,new  MyComprator());
	
		return list;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer thecustomer) {
		
		customerDao.saveCustomer(thecustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDao.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDao.deleteCustomer(theId);
		
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String thesearchname) {
		
		List<Customer> list=customerDao.searchCustomers(thesearchname);
		
		Collections.sort(list,new MyComprator());
		return list;
	}

}

class  MyComprator implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {


		return o1.getFirstName().compareTo(o2.getFirstName());
	}
	
}
