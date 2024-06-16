package com.example.FinanceApp.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FinanceApp.Entity.Users;

@Repository
public interface LoginDAO extends JpaRepository<Users,Integer>{

	List<Users> findByUserNameAndPassword(String string,String password);

}
