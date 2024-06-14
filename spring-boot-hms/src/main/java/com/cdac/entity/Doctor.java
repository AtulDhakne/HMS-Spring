package com.cdac.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_doctor")
public class Doctor {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
		private String age;
		private String emergencyNo;
		private String email;
		private String gender;
		private String bloodGroup;
		private LocalDate birthdate;
		private String address;
		private String education;
		private String department;
		private String password;
		private String otherDetails;
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
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getEmergencyNo() {
			return emergencyNo;
		}
		public void setEmergencyNo(String emergencyNo) {
			this.emergencyNo = emergencyNo;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getBloodGroup() {
			return bloodGroup;
		}
		public void setBloodGroup(String bloodGroup) {
			this.bloodGroup = bloodGroup;
		}
		public LocalDate getBirthdate() {
			return birthdate;
		}
		public void setBirthdate(LocalDate birthdate) {
			this.birthdate = birthdate;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getEducation() {
			return education;
		}
		public void setEducation(String education) {
			this.education = education;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getOtherDetails() {
			return otherDetails;
		}
		public void setOtherDetails(String otherDetails) {
			this.otherDetails = otherDetails;
		}
	}

