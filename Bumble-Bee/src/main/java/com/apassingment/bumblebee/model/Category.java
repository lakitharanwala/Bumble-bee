package com.apassingment.bumblebee.model;

public class Category {

	private String Id;
    private String category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
	
	
}
