package com.apassingment.bumblebee.model;

public class Products {
	
	private String Id;
    private String categoryId;
    private String categoryName;
    private String Name;
    private String quantity;
    private String price;
    private String brand;
    private String brandName;
    private Byte status;
    private String usedAmount;
    private String insertDateTime;
    private String updateDateTime;
    private String insertUser;
    private String updateUser;
    
    

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

	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}

    
