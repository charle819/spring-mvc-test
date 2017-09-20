package com.exampleZone.SpringMVCJavaBased.model;

public class Employee {

	private long e_id;
	private String e_name;
	private String e_role;
	private String e_emailId;
	private long e_contactNo;
	private String e_address;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Employee(long e_id, String e_name, String e_role, String e_emailId, long e_contactNo, String e_address) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
		this.e_role = e_role;
		this.e_emailId = e_emailId;
		this.e_contactNo = e_contactNo;
		this.e_address = e_address;
	}



	public long getE_id() {
		return e_id;
	}

	public void setE_id(long e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getE_role() {
		return e_role;
	}

	public void setE_role(String e_role) {
		this.e_role = e_role;
	}

	
	

	public String getE_emailId() {
		return e_emailId;
	}


	public void setE_emailId(String e_emailId) {
		this.e_emailId = e_emailId;
	}


	public long getE_contactNo() {
		return e_contactNo;
	}

	public void setE_contactNo(long e_contactNo) {
		this.e_contactNo = e_contactNo;
	}

	public String getE_address() {
		return e_address;
	}

	public void setE_address(String e_address) {
		this.e_address = e_address;
	}

}
