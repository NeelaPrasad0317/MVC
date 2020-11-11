package com.nnp.model;

public class Employee {
	private Integer empNo;
	private String ename;
	private String job;
	private Float sal=10000f;
	private Integer deptNo;
	private String valid;
	
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
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
	public Float getSal() {
		return sal;
	}
	public void setSal(Float sal) {
		this.sal = sal;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", ename=" + ename + ", job=" + job + ", sal=" + sal + ", deptNo=" + deptNo
				+ ", valid=" + valid + "]";
	}
	

}
