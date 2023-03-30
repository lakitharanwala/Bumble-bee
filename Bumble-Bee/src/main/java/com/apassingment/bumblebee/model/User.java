package com.apassingment.bumblebee.model;

public class User {

	private String userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String address;
    private String contact;
    private String emial;
    private String userRole; 
    private String dob;
    private String nationalIdentificationNumber;
    private String status;
    private String usedAmount;
    private String insertDateTime;
    private String updateDateTime;
    private String insertUser;
    private String updateUser;
    
	private User(String userId, String firstName, String lastName, String username, String password, String address,
			String contact, String emial, String userRole, String dob, String nationalIdentificationNumber,
			String status, String usedAmount, String insertDateTime, String updateDateTime, String insertUser,
			String updateUser) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.contact = contact;
		this.emial = emial;
		this.userRole = userRole;
		this.dob = dob;
		this.nationalIdentificationNumber = nationalIdentificationNumber;
		this.status = status;
		this.usedAmount = usedAmount;
		this.insertDateTime = insertDateTime;
		this.updateDateTime = updateDateTime;
		this.insertUser = insertUser;
		this.updateUser = updateUser;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmial() {
		return emial;
	}
	public void setEmial(String emial) {
		this.emial = emial;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getNationalIdentificationNumber() {
		return nationalIdentificationNumber;
	}
	public void setNationalIdentificationNumber(String nationalIdentificationNumber) {
		this.nationalIdentificationNumber = nationalIdentificationNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsedAmount() {
		return usedAmount;
	}
	public void setUsedAmount(String usedAmount) {
		this.usedAmount = usedAmount;
	}
	public String getInsertDateTime() {
		return insertDateTime;
	}
	public void setInsertDateTime(String insertDateTime) {
		this.insertDateTime = insertDateTime;
	}
	public String getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(String updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	public String getInsertUser() {
		return insertUser;
	}
	public void setInsertUser(String insertUser) {
		this.insertUser = insertUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
    
		
	
	
}
