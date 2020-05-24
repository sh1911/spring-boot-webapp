package com.alien.bloodhelper.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Embeddable
public class UserAddressEembeded {
	
	
	@Column(nullable = true)
	@Length(min = 12,max = 50,message = "Lenght of Address should be minimum 12 characters")
	private String address;
	@Column(nullable = true)
	@Length(min = 6,max = 6,message = "Lenght of Pincode should be 6")
	@Pattern(regexp = "[0-9]+" ,message="Pincode must contain Digits ")
	private String pincode;
	@Column(nullable = true)
	private String state;
	@Column(nullable = true)
	private String country;
	@Length(min = 2,max = 15,message = "Lenght of City should be between 2 and 15")
	@Pattern(regexp = "[A-Za-z]+" ,message="Invalid City ")
	@Column(nullable = true)
	private String city;
	@Length(min = 10,max = 10,message = "Lenght of Mobile should be 10")
	@Pattern(regexp = "[0-9]+" ,message="Invalid  mobilenumber")
	@Column(nullable = true)
	private String mobileno;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

}
