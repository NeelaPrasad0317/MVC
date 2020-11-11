package com.nnp.dao;

import java.util.List;

import com.nnp.bo.EmployeeBO;

public interface IEmployeeDAO {
	List<EmployeeBO> getAllEmployee();

	Integer insertEmp(EmployeeBO bo);

	List<Integer> getAllDeptNos();

	Integer deleteEmp(Integer empNo);

	EmployeeBO getEmp(Integer empNo);

	int update(EmployeeBO bo);
}
