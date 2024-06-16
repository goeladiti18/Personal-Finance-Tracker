package com.example.FinanceApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FinanceApp.DAO.UserDAO;
import com.example.FinanceApp.Entity.Users;

@Service
public class UserService {
	
	@Autowired
	UserDAO ud;

	public Users find(int id) {
		// TODO Auto-generated method stub
		return ud.findById(id);
	}

	public Users findByUsername(String userName) {
		// TODO Auto-generated method stub
		return ud.findByUserName(userName);
	}
	
	

}
