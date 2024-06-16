package com.example.FinanceApp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FinanceApp.Entity.Users;
@Repository
public interface UserDAO extends JpaRepository<Users,Integer> {
	
	Users findById(int id);

	Users findByUserName(String userName);

}
