package com.nnp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nnp.bo.EmployeeBO;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_ALL_EMP="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<EmployeeBO> getAllEmployee() {
		List<EmployeeBO> listbo=null;
		listbo=jt.query(GET_ALL_EMP,new resultSetMapper() );
		return listbo;
	}
	
	private class resultSetMapper implements ResultSetExtractor<List<EmployeeBO>>{

		@Override
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<EmployeeBO> libos=new ArrayList<EmployeeBO>();
			while(rs.next()) {
				EmployeeBO bo=new EmployeeBO();
				//EMPNO,ENAME,JOB,SALARY,DEPTNO
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSalary(rs.getFloat(4));
				bo.setDeptNo(rs.getInt(5));
				libos.add(bo);
			}
			return libos;
		}
		
	}

}
