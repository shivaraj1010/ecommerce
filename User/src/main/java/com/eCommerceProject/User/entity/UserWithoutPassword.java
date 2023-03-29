package com.eCommerceProject.User.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


	@Entity
	
	public class UserWithoutPassword {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private String firstName;
		private String lastName;
		private String middleName;
		private String phoneNumber;
		private String email;
		private String address;
		private String dateOfBirth;
		private Gender gender;
		
		public UserWithoutPassword() {
			
		}

		public UserWithoutPassword(Long id, String firstName, String lastName, String middleName, String phoneNumber,
				String email, String address, String dateOfBirth, Gender gender) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.middleName = middleName;
			this.phoneNumber = phoneNumber;
			this.email = email;
			this.address = address;
			this.dateOfBirth = dateOfBirth;
			this.gender = gender;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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
		
		
}
