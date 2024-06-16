package com.example.FinanceApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FinanceApp.DAO.ExpenseDAO;
import com.example.FinanceApp.DAO.SignUpDAO;
import com.example.FinanceApp.Entity.Expense;
@Service
public class ExpenseService {

@Autowired
ExpenseDAO ed;


	
	public void saveData(Expense e) {
		// TODO Auto-generated method stub
		if(e.getExpenseType().equalsIgnoreCase("Expenditure")) {
			e.setAmount(-e.getAmount());
		}
		ed.save(e);
	}



	public double getTotalExpenseperMonth(int month, int year) {
		// TODO Auto-generated method stub
		 String expenseType = "Expenditure";
	        Double result = ed.findTotalAmountByMonthAndYear(month, year, expenseType);
	        return result != null ? result : 0.0; // Return 0.0 if result is null
	}



	public double getTotalExpenseperYear(int year) {
		String expenseType = "Expenditure";
        Double result = ed.findTotalAmountByYear(year, expenseType);
        return result != null ? result : 0.0; // Return 0.0 if result is null
		
	}

}
