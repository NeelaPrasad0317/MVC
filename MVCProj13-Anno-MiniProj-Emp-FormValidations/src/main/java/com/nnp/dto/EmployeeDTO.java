package com.nnp.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer slno;
	private Integer empNo;
	private String ename;
	private String job;
	private float sal;
	private int deptNo;
	private float netSalary;
	private float grossSalary;
	
	public Integer getSlno() {
		return slno;
	}
	public void setSlno(Integer slno) {
		this.slno = slno;
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
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [slno=" + slno + ", empNo=" + empNo + ", ename=" + ename + ", job=" + job + ", sal=" + sal
				+ ", deptNo=" + deptNo + ", netSalary=" + netSalary + ", grossSalary=" + grossSalary + "]";
	}
	
	
}
