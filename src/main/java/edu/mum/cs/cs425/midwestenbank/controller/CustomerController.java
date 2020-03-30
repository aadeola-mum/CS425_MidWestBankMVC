/**
 * 
 */
package edu.mum.cs.cs425.midwestenbank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.midwestenbank.model.Customer;
import edu.mum.cs.cs425.midwestenbank.service.CustomerService;


/**
 * @author Adeola Adeleke
 *
 */

@Controller
@RequestMapping(value = "/customers")
public class CustomerController {
	
	private CustomerService customerService;
	/**
	 * @param customerService
	 */
	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping(value= {"", "/", "/list"})
	public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<Customer> studs = customerService.getAll();
        System.err.println(studs);
        modelAndView.addObject("customers", studs);
        modelAndView.addObject("customerCount", studs.size());
        modelAndView.setViewName("customers/list");
        return modelAndView;
    }
	
	
	@GetMapping(value= {"/new"})
	public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customer", new Customer());
       // modelAndView.addObject("suppliers", supplierService.getAll());
        modelAndView.setViewName("customers/new");
        return modelAndView;
    }
	
	@GetMapping(value= {"/edit/{customerId}"})
	public ModelAndView edit(@PathVariable("customerId") long customerId) {
        ModelAndView modelAndView = new ModelAndView();
       // modelAndView.addObject("suppliers", supplierService.getAll());
        modelAndView.addObject("customer", customerService.get(customerId).orElse(new Customer()));
        modelAndView.setViewName("customers/new");
        return modelAndView;
    }
	
	@PostMapping(value= {"/save"})
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult, Model model) throws Exception {
		System.err.println(customer);
		if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "customers/new";
        }
		
        Customer savedCustomer = customerService.save(customer);
        if(savedCustomer != null) {
        	return "redirect:/customers/list";
        }
        return "customers/new";
    }
}
