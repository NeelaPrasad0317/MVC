package com.nnp.bo;

public class EmployeeBO {
	private int empNo;
	private String ename;
	private String job;
	private float salary;
	private int deptNo;
	
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
		return "EmployeeBO [empNo=" + empNo + ", ename=" + ename + ", job=" + job + ", salary=" + salary + ", deptNo="
				+ deptNo + "]";
	}
	
	
}
