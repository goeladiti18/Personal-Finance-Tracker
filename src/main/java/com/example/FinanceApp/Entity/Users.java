package com.example.FinanceApp.Entity;



import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
 
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String password;
	@OneToMany(mappedBy="users")
	private List<Expense> expense;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users(int id, String userName, String password, List<Expense> expense) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.expense = expense;
	}
	public List<Expense> getExpense() {
		return expense;
	}
	public void setExpense(List<Expense> expense) {
		this.expense = expense;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Users(int id,String userName, String password) {
		super();
		this.id=id;
		this.userName = userName;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
