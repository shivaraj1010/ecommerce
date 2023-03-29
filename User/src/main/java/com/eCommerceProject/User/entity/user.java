package com.eCommerceProject.User.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="users")
public class user {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String firstName;
	private String lastName;
	private String middleName;
	private String phoneNumber;
	private String email;
	private String address;
	private String dateOfBirth;
	//@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	@Column(length=20)
	private String password;
	@Temporal(TemporalType.DATE)
	private Date createdDate=new Date(System.currentTimeMillis());
	@Temporal(TemporalType.DATE)
	private Date updatedDate=new Date(System.currentTimeMillis());
	public user(){
		
	}
	
	

	public user(Long userId, String firstName, String lastName, String middleName, String phoneNumber, String email,
			String address, String dateOfBirth, Gender gender, String password, Date createdDate, Date updatedDate) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.password = password;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}



	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public Date getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public Date getUpdatedDate() {
		return updatedDate;
	}



	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}



	@Override
	public String toString() {
		return "user [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", password=" + password + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}
	
	
}
