package com.woniu.m_validate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	@Min(value = 100 , message = "{validate.id.min}" , groups = {A.class,B.class})
	private Integer id;
	@Size(min = 2 , max = 4 , message = "{validate.username.size}" , groups = A.class)
	@Size(min = 3 , max = 6 , message = "{validate.username.size}" , groups = B.class)
	private String username;
	@Size(min = 3 , max = 6 , message = "{validate.password.size}" , groups = {A.class,B.class})
	private String password;
	@Digits(integer = 5 , fraction = 2 , message = "{validate.money.digits}" , groups = {A.class,B.class} )
	private Double money;
	@Pattern(regexp = "1[35789]\\\\d{9}" , message = "{validate.cellphone.regexp}" , groups = {A.class,B.class} )
	private String cellphone;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", money=" + money
				+ ", cellphone=" + cellphone + "]";
	}
	
}
