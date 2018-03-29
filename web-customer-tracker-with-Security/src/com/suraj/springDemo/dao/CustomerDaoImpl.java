package com.suraj.springDemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suraj.springDemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomer() {
		
		//get the current hibernate session 
		
		Session currentSession =sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery=currentSession.createQuery("from Customer",Customer.class);
		
		//execute query and get result set 
		
		List<Customer> customers= theQuery.getResultList();
		
		//return the result
	 System.out.println(customers);
		return customers;
	}

	@Override
	public void saveCustomer(Customer thecustomer) {
		
		//get Current session
		
		Session currentSession =sessionFactory.getCurrentSession();
		
		
	    //save the customer
		currentSession.saveOrUpdate(thecustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		//get Current session
		
		Session currentSession =sessionFactory.getCurrentSession();
	
		//get customer
		
		Customer theCustomer=currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		//get Current session
		
		Session currentSession =sessionFactory.getCurrentSession();
			
		//delete the customer 
		
		Query theQuery=
				currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Customer> searchCustomers(String thesearchname) {
		
		//get Current session
		
				Session currentSession =sessionFactory.getCurrentSession();
				
				Query theQuery=null;
					
				if (thesearchname != null && thesearchname.trim().length() > 0)
				{
				theQuery=currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
				
				theQuery.setParameter("theName", "%" + thesearchname.toLowerCase() + "%");
				
				}
				
				else {
		            // theSearchName is empty ... so just get all customers
		            theQuery =currentSession.createQuery("from Customer", Customer.class);            
		        }
			    // execute query and get result list
		        List<Customer> customers = theQuery.getResultList();
		                
		        // return the results        
		        return customers;
				
	}

}
