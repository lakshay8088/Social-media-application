package com.lakshay.mydemorestapi.Bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@NamedQuery(name="find_all_users",query = "select p from Users p")
public class Users {

	@Id
	private int id;
	
	@Size(min=2, message="name should have atleast 2 characters")
	private String name;
	private String Address;
	private int phoneNo;
	private String gender;
	
	
	
	public Users() {
		super();
	}
	public Users(int id, String name, String address, int phoneNo, String gender) {
		super();
		this.id = id;
		this.name = name;
		Address = address;
		this.phoneNo = phoneNo;
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", Address=" + Address + ", phoneNo=" + phoneNo + ", gender="
				+ gender + "]";
	}
	
}
