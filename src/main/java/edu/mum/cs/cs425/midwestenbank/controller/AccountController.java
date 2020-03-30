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

import edu.mum.cs.cs425.midwestenbank.model.Account;
import edu.mum.cs.cs425.midwestenbank.model.Customer;
import edu.mum.cs.cs425.midwestenbank.service.AccountService;

/**
 * @author Adeola Adeleke
 *
 */

@Controller
@RequestMapping(value = "/accounts")
public class AccountController {
	
	
	private AccountService accountService;
	
	/**
	 * @param accountService
	 */
	@Autowired
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@GetMapping(value= {"/list", "/", ""})
	public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<Account> studs = accountService.getAll();
       // System.err.println(studs);
        modelAndView.addObject("accounts", studs);
        modelAndView.addObject("accountCount", studs.size());
        modelAndView.setViewName("accounts/list");
        return modelAndView;
    }
	
	@GetMapping(value= {"/netliq"})
	public ModelAndView netLiq() {
        ModelAndView modelAndView = new ModelAndView();
        double totalSavings = accountService.totalSavings();
        double totalCheckings = accountService.totalCheckings();
        double totalLoans = accountService.totalLoans();
        double netliq = (totalSavings + totalCheckings) - totalLoans;
//        System.err.println(studs);
        modelAndView.addObject("ts", totalSavings);
        modelAndView.addObject("tc", totalCheckings);
        modelAndView.addObject("tl", totalLoans);
        modelAndView.addObject("nl", netliq);
        modelAndView.setViewName("accounts/netliq");
        return modelAndView;
    }
	
	@GetMapping(value= {"/new"})
	public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("account", new Account());
       // modelAndView.addObject("suppliers", supplierService.getAll());
        modelAndView.setViewName("accounts/new");
        return modelAndView;
    }
	
	@GetMapping(value= {"/edit/{accountId}"})
	public ModelAndView edit(@PathVariable("accountId") long accountId) {
        ModelAndView modelAndView = new ModelAndView();
       // modelAndView.addObject("suppliers", supplierService.getAll());
        modelAndView.addObject("account", accountService.get(accountId).orElse(new Account()));
        modelAndView.setViewName("accounts/new");
        return modelAndView;
    }
	
	@PostMapping(value= {"/save"})
	public String saveAccount(@Valid @ModelAttribute("account") Account account,
            BindingResult bindingResult, Model model) throws Exception {
		System.err.println(account);
		if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "accounts/new";
        }
		
        Account savedAccount = accountService.save(account);
        if(savedAccount != null) {
        	return "redirect:/accounts/list";
        }
        return "accounts/new";
    }
}
