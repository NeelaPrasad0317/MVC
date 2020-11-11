package com.nnp.service;

import java.util.List;

import com.nnp.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
	List<EmployeeDTO> fetchEmployeeDetails();
	String addEmp(EmployeeDTO dto);
	List<Integer> fetchAllDeptNos();
	String deleteEmpByID(Integer empNo);
	EmployeeDTO getEmpByID(Integer empNo);
	String updateEmp(EmployeeDTO dto);
}
