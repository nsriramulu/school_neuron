package com.sn.constants;

/**
 * @author 419348
 *	This enum contains constants used in JSON response
 */
public enum ResponseStatus {
	STATUS("STATUS"),
	TITLE("TITLE"),
	MESSAGE("MESSAGE"),
	SUCCESS("SUCCESS"), 
	FAILURE("FAILURE"), 
	ERROR("ERROR");
	 
	private String status;
 
	private ResponseStatus(String s) {
		status = s;
	}
 
	public String getCode() {
		return status;
	}
}
