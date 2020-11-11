package com.nnp.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int empNo;
	private String ename;
	private String job;
	private float salary;
	private int deptNo;
	private float netSalary;
	private float grossSalary;
	
	public float getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(float netSalary) {
		this.netSalary = netSalary;
	}
	public float getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(float grossSalary) {
		this.grossSalary = grossSalary;
	}
	
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [empNo=" + empNo + ", ename=" + ename + ", job=" + job + ", salary=" + salary + ", deptNo="
				+ deptNo + ", netSalary=" + netSalary + ", grossSalary=" + grossSalary + "]";
	}
	
	
}
