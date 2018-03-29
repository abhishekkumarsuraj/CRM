package com.suraj.springDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.suraj.springDemo.entity.Customer;
import com.suraj.springDemo.services.CustomerService;


@Controller
@RequestMapping("customer")
public class CustomerController {
	
	
	
	//need to inject the customer dao
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel)
	{
		//get customer from the service
		List<Customer> theCustomers=customerService.getCustomers();
		
		//add the customer to the model
		
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customer";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		
		//create model attribute to bind form data
		
		Customer thecustomer=new Customer();
		
	    theModel.addAttribute("customer",thecustomer);
	   
		return "customer-form";
		
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer thecustomer)
	{
		//save the customer using service 
		
		customerService.saveCustomer(thecustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel)
	{
		//get customer from dataBase
		Customer thecustomer =customerService.getCustomer(theId);
		
		//set customer as a model attribute to pre-populate the form
		System.out.println("***********");
		System.out.println(thecustomer);
		
		theModel.addAttribute("customer",thecustomer);
		
		//send over to our form
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId)
	{
		//delete customer from dataBase
		
		customerService.deleteCustomer(theId);
		
		System.out.println(theId);
		return "redirect:/customer/list";
	}
	
	@PostMapping("/search")
	public String searchCustomer(@RequestParam("thesearchname") String thesearchname,Model theModel)
	{
		// search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(thesearchname);
        
        //create model
        
        theModel.addAttribute("customers",theCustomers);
		
		return "list-customer";
	}
	
	
	@GetMapping("/")
	public String showHome()
	{
		return "home";
	}

}
