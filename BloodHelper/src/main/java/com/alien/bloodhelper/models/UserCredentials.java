package com.alien.bloodhelper.models;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



@Component
@Qualifier("users")
@Entity
public class UserCredentials {
	
	
	@Email
	@Column(nullable = false)
	private String email;
	@Length(min = 8,max = 10,message = "Lenght of password should be between 8 and 10")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,12})",message = "A Password must contain one Uppecase and Lowercase ,one Digit and Special[@#$8] characters")
	@Column(nullable = false)
	private String password;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,name="userrole")
	private String UserRole;
	@Column(nullable = false,updatable = false)
	@CreationTimestamp
	private Date date;
	@Column(nullable = false,updatable = false)
	@CreationTimestamp
	private Time time;
	@Column(nullable = false)
	@Pattern(regexp = "[A-Za-z/S].{3,20}+" ,message="Invalid Fristname")
	private String fname;
	@Pattern(regexp = "[A-Za-z/S].{3,20}+" ,message="Invalid Lastname")
	@Column(nullable = false)
	private String lname;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private String dateofbirth;
	@Column
	private String username;
	/*@Min(value = 18,message = "Age must be above 18years")
	private int age;*/
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private UserAddressEembeded address;
	public UserAddressEembeded  getAddress() {
		return address;
	}
	public void setAddress(UserAddressEembeded  address) {
		this.address = address;
	}
	
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) throws ParseException {
		this.dateofbirth = dateofbirth;
		//setAge();
	}
	/*public void setAge() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date d =sdf.parse(dateofbirth);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		LocalDate l1 = LocalDate.of(year, month, date);
		LocalDate now1 = LocalDate.now();
		Period period = Period.between(l1, now1);
		
		this.age =period.getYears() ;
	}*/
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUserRole() {
		return UserRole;
	}
	public void setUserRole(String userRole) {
		UserRole = userRole;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "UserCredentials [email=" + email + ", password=" + password + ", id=" + id + ", UserRole=" + UserRole
				+ ", date=" + date + ", time=" + time + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender
				+ ", dateofbirth=" + dateofbirth + ", username=" + username +" address=" + address
				+ "]";
	}
	
}
