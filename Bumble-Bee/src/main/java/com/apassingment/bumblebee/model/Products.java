package com.apassingment.bumblebee.model;

public class Products {
	
	private String Id;
    private String categoryId;
    private String Name;
    private String brand;
    private String status;
    private String usedAmount;
    private String insertDateTime;
    private String updateDateTime;
    private String insertUser;
    private String updateUser;
    
    
    
    private Products(String id, String categoryId, String name, String brand, String status, String usedAmount,
		String insertDateTime, String updateDateTime, String insertUser, String updateUser) {
		Id = id;
		this.categoryId = categoryId;
		Name = name;
		this.brand = brand;
		this.status = status;
		this.usedAmount = usedAmount;
		this.insertDateTime = insertDateTime;
		this.updateDateTime = updateDateTime;
		this.insertUser = insertUser;
		this.updateUser = updateUser;
	}



    public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
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

    
