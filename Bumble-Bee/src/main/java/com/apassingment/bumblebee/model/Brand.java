package com.apassingment.bumblebee.model;

public class Brand {

	private String Id;
    private String Name;
    private Byte status;
    private String usedAmount;
    private String insertDateTime;
    private String updateDateTime;
    private String insertUser;
    private String updateUser;
    
	/*
	 * private Brand(String id, String name, String status, String usedAmount,
	 * String insertDateTime, String updateDateTime, String insertUser, String
	 * updateUser) { super(); setId(id); setName(name); this.setStatus(status);
	 * this.setUsedAmount(usedAmount); this.setInsertDateTime(insertDateTime);
	 * this.setUpdateDateTime(updateDateTime); this.setInsertUser(insertUser);
	 * this.setUpdateUser(updateUser); }
	 */

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
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
    
    
}
