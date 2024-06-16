package com.example.FinanceApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.FinanceApp.Entity.Expense;
import com.example.FinanceApp.Entity.Users;
import com.example.FinanceApp.Service.ExpenseService;
import com.example.FinanceApp.Service.LoginService;
import com.example.FinanceApp.Service.SignUpService;
import com.example.FinanceApp.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyMainController {
	
	//private static Users UserData;
	
	 @Autowired 
	 SignUpService us;
	 
	 @Autowired
	 LoginService ls;
	 
     @Autowired
     ExpenseService es;
     
     @Autowired
     UserService uss;
     
     
     //User selects login on the index page
	 @GetMapping("/loginD")
	    public String LogIn(Model m) {
	    	m.addAttribute("loginData",new Users());
	    	return "LogIn";
	    }
	 
	 
	 @PostMapping("/FinanceAppMainPage")
	 public String successLogIn(@ModelAttribute("loginData") Users u,Model m,HttpSession session){
		 boolean result= ls.logIn(u);//checks if this username exists or not in db
	    	System.out.println(u.toString());
	    	
	    	if (result) {//if true, add expense attribute and store users data and return to financial home page
	    	
	    		m.addAttribute("successMessage","Please enter our credentials");
	    	m.addAttribute("expenseData",new Expense());
	    	
	    	Users userFromDb = uss.findByUsername(u.getUserName());
	    	session.setAttribute("loggedInUser", userFromDb);
	    	 
	    	return "financeHomePage";
             }
	    	else {//if false, add the attribute again and return to login page
	    		m.addAttribute("loginData", new Users());
	    		m.addAttribute("successMessage","Wrong credentials, please log in again");
	    		return "LogIn";

	    	}
	    }
	 
	
 
 
 
	 
//User selects signUp page on index page
	 @GetMapping("/signup")
	    public String SignUp(Model m) {
	    	m.addAttribute("loginData",new Users());
	    	return "signUp";
	    }
	 //if success, add into db
	 @PostMapping("/login")
	 public String success(@ModelAttribute("loginData") Users u,Model m){
		boolean result= us.signIn(u);
		
	    	System.out.println(u.toString());
	    	System.out.println(result);
	    	if (result)
	    	{m.addAttribute("successMessage","You're signed in,"+u.getUserName()+" Now please log in again with same credentials");
	    	m.addAttribute("loginData", new Users());
	    	return "LogIn";}
	    	else {
	    		m.addAttribute("successMessage","Username,"+u.getUserName()+"already exists,  please sign in again with different credentials");
	    		return "signUp";
	    	}
	    	
	    	
	    }
	 
	 
	 

	
	 
	
	
	//save the expense data in db 
	 @PostMapping("/addExpense")
	    public String addExpense(@ModelAttribute("expenseData")Expense e,HttpSession session,Model m) {
		 Users loggedInUser = (Users) session.getAttribute("loggedInUser");
		 if(loggedInUser!=null)
	    	{
			Users dbExistId=uss.find(loggedInUser.getId());
			 e.setUsers(dbExistId);
		 es.saveData(e);
		 m.addAttribute("Message","Expense data added succeessfully");
	    	return "financeHomePage";
	    }else {
	    	return "fail";
	    }
	 
	 } 
	 
	@PostMapping("/logout")
	public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "index"; // Redirect to your login page or home page
    } 
	  
	 }



