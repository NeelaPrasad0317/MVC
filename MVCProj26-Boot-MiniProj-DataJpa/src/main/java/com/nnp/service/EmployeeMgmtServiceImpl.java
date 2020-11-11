package com.nnp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnp.bo.EmployeeBO;
import com.nnp.dao.IEmployeeDAO;
import com.nnp.dto.EmployeeDTO;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeDAO dao;
	
	/*-------------------get all emp details---------------------------*/
	@Override
	public List<EmployeeDTO> fetchEmployeeDetails() {
		List<EmployeeBO> libos=null;
		List<EmployeeDTO> lidtos=new ArrayList<EmployeeDTO>();
		
		libos=dao.getAllEmployee();
		libos.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			//EMPNO,ENAME,JOB,SALARY,DEPTNO--bo
			//empNo,ename,job,salary,deptNo,netSalary,grossSalary---dto
			dto.setSlno(lidtos.size()+1);
			dto.setGrossSalary(bo.getSal()+bo.getSal()*0.3f);
			dto.setNetSalary(dto.getGrossSalary()-dto.getGrossSalary()*0.1f);
			lidtos.add(dto);
		});
		return lidtos;
	}

	/*--------------------------insert emp-------------------------*/
	@Override
	public String addEmp(EmployeeDTO dto) {
		//create and copy data to bo
		EmployeeBO bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//insert record into db using dao
		Integer count=dao.insertEmp(bo);
		return (count==0)?"New Employee record insertion failed":"New Employee record inserted sucessfully";
	}

	/*------------------------get dept nos----------------------------*/
	@Override
	public List<Integer> fetchAllDeptNos() {
		return dao.getAllDeptNos();
	}

	/*------------------------delete emp by ID----------------------------*/
	@Override
	public String deleteEmpByID(Integer empNo) {
		//perform delete operation by using dao
		Integer count=dao.deleteEmp(empNo);
		return count==0?"Employee with empNo::"+empNo+" is unable to delete,pls try again later":"Employee with empNo::"+empNo+" is deleted.";
	}

	/*-----------------------get emp by id----------------------------------*/
	@Override
	public EmployeeDTO getEmpByID(Integer empNo) {
		EmployeeBO bo=null;
		EmployeeDTO dto=new EmployeeDTO();
//		get emp details from table by empno
		bo=dao.getEmp(empNo);
		BeanUtils.copyProperties(bo, dto);
		System.out.println(dto);
		return dto;
	}

	/*-----------------------update emp----------------------------------*/
	@Override
	public String updateEmp(EmployeeDTO dto) {
		EmployeeBO bo=new EmployeeBO();
		System.out.println(dto);
		BeanUtils.copyProperties(dto, bo);
		int count=dao.update(bo);
		System.out.println(count);
		return count==0?"Unable to update the employee details at the moment...pls try again later":"Employee NO::"+dto.getEmpNo()+" details updated sucessfully";
	}

}
