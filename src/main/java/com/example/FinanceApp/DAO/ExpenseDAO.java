package com.example.FinanceApp.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.FinanceApp.Entity.Expense;
@Repository
public interface ExpenseDAO extends JpaRepository<Expense,Integer> {

	 @Query(value = "SELECT SUM(amount) FROM Expense WHERE month = :month AND year = :year AND expense_type = :expense_type", nativeQuery = true)
	    Double findTotalAmountByMonthAndYear(int month, int year,String expense_type);

	 
	 @Query(value = "SELECT SUM(amount) FROM Expense WHERE year = :year AND expense_type = :expense_type", nativeQuery = true)
	double findTotalAmountByYear(int year, String expense_type);
	}
	


