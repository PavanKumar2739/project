package com.example.springform1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springform1.dto.Customer;

@Controller
public class formMain {
	@Autowired
	CustomerRepo custRepo;
    @GetMapping (value = "/")
	public String home() {
		return "front.jsp";
	}
    
    @PostMapping(value = "/addCustomer")
    public String addCustomer(Model model,Customer cust) {
//		System.out.println("addCustomer is triggered");
//		System.out.println(firstname+" "+lastname+" "+email);
//		model.addAttribute("firstname",firstname);
//		model.addAttribute("lastname",lastname);
//		model.addAttribute("email",email);
    	model.addAttribute("data",custRepo.findAll());
		custRepo.save(cust);
		return "success1.jsp";
	}   


}
