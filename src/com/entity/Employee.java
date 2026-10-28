package com.entity;

public class Employee {
	
	private int eid;
	private String ename;
	private String eaddress;
	private int esalary;
	
	public Employee() {
		// This default constructor will be used by the Hibernate at the time of reading data from DB
		// Because Hibernate gives us the Employee obj directly while reading, it uses the default constructor to create the obj
		// first then use the setters to populate it with values.
	}
	
	public Employee(int eid, String ename, String eaddress, int esalary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eaddress = eaddress;
		this.esalary = esalary;
	}
	
	public int getEid() {
		return eid;
	}
	
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	public String getEname() {
		return ename;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String getEaddress() {
		return eaddress;
	}
	
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	
	public int getEsalary() {
		return esalary;
	}
	
	public void setEsalary(int esalary) {
		this.esalary = esalary;
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + ", esalary=" + esalary + "]";
	}
	
}
