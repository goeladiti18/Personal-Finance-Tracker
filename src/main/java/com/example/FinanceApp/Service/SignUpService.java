package com.example.FinanceApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.FinanceApp.DAO.SignUpDAO;
import com.example.FinanceApp.Entity.Users;

@Service
public class SignUpService {
	@Autowired
	SignUpDAO ud;

	public boolean signIn(Users u) {
		// TODO Auto-generated method stub
		
		List<Users> exist=ud.findByUserName(u.getUserName());
		
		
		if(!exist.isEmpty())
			{System.out.println("User already exists");
			return false;}
		else {
		ud.save(u);
		System.out.println("Signed in successfully");
		return true;
		
			}
		
	}

	
}
