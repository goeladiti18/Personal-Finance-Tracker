package com.example.FinanceApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.FinanceApp.Entity.Expense;
import com.example.FinanceApp.Service.ExpenseService;



@Controller
public class CalculationController {
	
	
	@Autowired
	ExpenseService es;
	
	  @GetMapping("/totalExpenseMonth") public String getData(Model m) { //Expense
	 /* e=new Expense(); 
	  m.addAttribute("data",new Expense());*/
	  
	  
	  return "totalExpenseMonth";
	  
	  }
	 
	
	@PostMapping("/totalExpenseMonth")
	public String getTotalExpenseperMonth(@RequestParam("month")int month,@RequestParam("year")int year ,Model m)	{
		double result=es.getTotalExpenseperMonth(month,year);
		m.addAttribute("result",-result);
		System.out.println(result);
		return "totalExpenseMonth";
		
	}
	
	
	 @GetMapping("/totalExpenseYear") public String getData2(Model m) { //Expense
		 /* e=new Expense(); 
		  m.addAttribute("data",new Expense());*/
		  
		  
		  return "totalExpenseYear";
		  
		  }
		 
		
		@PostMapping("/totalExpenseYear")
		public String getTotalExpenseperYear(@RequestParam("year")int year ,Model m)	{
			double result=es.getTotalExpenseperYear(year);
			m.addAttribute("result",-result);
			System.out.println(result);
			double[] monthExpenses = new double[12];
	        for (int i = 0; i < 12; i++) {
	            monthExpenses[i] = es.getTotalExpenseperMonth(i + 1, year);
	            
	        }
	        for(double j:monthExpenses) {
	        	System.out.println(monthExpenses[(int) j]);
	        }
	        m.addAttribute("monthExpenses", monthExpenses);
			return "totalExpenseYear";
			
		}
	
	
	

}
