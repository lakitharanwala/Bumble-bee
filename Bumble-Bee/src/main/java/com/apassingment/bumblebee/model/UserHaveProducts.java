package com.apassingment.bumblebee.model;

public class UserHaveProducts {

	private String Id;
    private String productId;
    private String loanBalance;
    private String userId;
    private String status;
    private String insertDateTime;
    private String updateDateTime;
    private String insertUser;
    private String updateUser;
    
	private UserHaveProducts(String id, String productId, String loanBalance, String userId, String status,
			String insertDateTime, String updateDateTime, String insertUser, String updateUser) {
		super();
		setId(id);
		this.setProductId(productId);
		this.setLoanBalance(loanBalance);
		this.setUserId(userId);
		this.setStatus(status);
		this.setInsertDateTime(insertDateTime);
		this.setUpdateDateTime(updateDateTime);
		this.setInsertUser(insertUser);
		this.setUpdateUser(updateUser);
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getLoanBalance() {
		return loanBalance;
	}

	public void setLoanBalance(String loanBalance) {
		this.loanBalance = loanBalance;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
