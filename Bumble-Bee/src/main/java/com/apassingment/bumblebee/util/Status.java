package com.apassingment.bumblebee.util;

public enum Status {
		
		DELETED((byte)1), 
		ACTIVE((byte)0);
		
		public byte databaseValue = 0;
		
		Status(byte dbValue) {
			this.databaseValue = dbValue;
		}

		public byte getDatabaseValue() {
			return databaseValue;
		}

		public void setDatabaseValue(byte databaseValue) {
			this.databaseValue = databaseValue;
		}
		
		public static Status forCode(int code) {
			
		    for (Status enm : Status.values()) {
		        if (enm.getDatabaseValue() == code) {
		            return enm;
		        }
		    }
		    
		    return null;
		 }

		
	}

	
	

