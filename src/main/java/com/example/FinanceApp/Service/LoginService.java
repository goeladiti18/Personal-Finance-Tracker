package com.example.FinanceApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.FinanceApp.DAO.LoginDAO;

import com.example.FinanceApp.Entity.Users;
@Service
public class LoginService {
	@Autowired
	LoginDAO ld;

	public boolean logIn(Users u) {
		// TODO Auto-generated method stub
		List<Users> data=ld.findByUserNameAndPassword(u.getUserName(),u.getPassword());
		if(!data.isEmpty()) {
		System.out.println("Logged in successfully");
		return true;}
		else {
			System.out.println("please sign in first");
			return false;
		}
		
		
		
		
	}

}
