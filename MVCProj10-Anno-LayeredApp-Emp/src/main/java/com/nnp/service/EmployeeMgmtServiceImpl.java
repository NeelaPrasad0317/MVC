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
			dto.setGrossSalary(bo.getSalary()+bo.getSalary()*0.3f);
			dto.setNetSalary(dto.getGrossSalary()-dto.getGrossSalary()*0.1f);
			lidtos.add(dto);
		});
		
		return lidtos;
	}

}
