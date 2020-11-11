package com.nnp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nnp.bo.EmployeeBO;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_ALL_EMP="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP ORDER BY EMPNO ";
	private static final String INSERT_EMP="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL,DEPTNO) VALUES(EMPNO_SEQ.NEXTVAL,?,?,?,?)";
	private static final String GET_ALL_DEPTNO="SELECT DISTINCT DEPTNO FROM DEPT";
	private static final String DELETE_EMP_BY_ID="DELETE FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_BY_ID="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	private static final String UPDATE_EMP="UPDATE EMP SET ENAME=?,JOB=?,SAL=?,DEPTNO=? WHERE EMPNO=?";
	
	@Autowired
	private JdbcTemplate jt;

	/*------------------------get dept nos----------------------------*/
	@Override
	public List<EmployeeBO> getAllEmployee() {
		List<EmployeeBO> listbo=null;
		listbo=jt.query(GET_ALL_EMP,new ResultSetMapper());
		return listbo;
	}
	
	/*------------------------get dept nos----------------------------*/
	@Override
	public List<Integer> getAllDeptNos() {
		return jt.queryForList(GET_ALL_DEPTNO, Integer.class);
	}

	/*------------------------delete emp by ID----------------------------*/
	@Override
	public Integer deleteEmp(Integer empNo) {
		return jt.update(DELETE_EMP_BY_ID, empNo);
	}

	/*--------------------------insert emp-------------------------*/
	@Override
	public Integer insertEmp(EmployeeBO bo) {
		//use jt and insert record
		int count=jt.update(INSERT_EMP, bo.getEname(),bo.getJob(),bo.getSal(),bo.getDeptNo());
		return count;
	}
	
	/*-----------------------get emp by id----------------------------------*/
	/*@Override
	public EmployeeBO getEmp(Integer empNo) {
		EmployeeBO bo=null;
		bo=jt.queryForObject(GET_EMP_BY_ID,new RsRowMapper(),empNo);
		return bo;
	}
	*/
	/*@Override
	public EmployeeBO getEmp(Integer empNo) {
		EmployeeBO bo1=null;
		bo1=jt.queryForObject(GET_EMP_BY_ID,(rs,rowNum)->{
			EmployeeBO bo=new EmployeeBO();
			bo.setEname(rs.getString(1));
			bo.setJob(rs.getString(2));
			bo.setSalary(rs.getFloat(3));
			bo.setDeptNo(rs.getInt(4));
			return bo;
		},empNo);
		return bo1;
	}*/
	@Override
	public EmployeeBO getEmp(Integer empNo) {
		EmployeeBO bo=null;
		bo=jt.queryForObject(GET_EMP_BY_ID,new BeanPropertyRowMapper<>(EmployeeBO.class),empNo);
		System.out.println(bo);
		return bo;
	}
	
	/*-----------------UPDATE----------------------------*/	
	@Override
	public int update(EmployeeBO bo) {
		System.out.println(bo);
		return jt.update(UPDATE_EMP, bo.getEname(),bo.getJob(),bo.getSal(),bo.getDeptNo(),bo.getEmpNo());
	}
	
	/*-----------------Inner classes----------------------------*/	
	/*private class RsRowMapper implements RowMapper<EmployeeBO>{

		@Override
		public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeBO bo=new EmployeeBO();
			bo.setEname(rs.getString(1));
			bo.setJob(rs.getString(2));
			bo.setSalary(rs.getFloat(3));
			bo.setDeptNo(rs.getInt(4));
			return bo;
		}
	}
	*/
	
	private class ResultSetMapper implements ResultSetExtractor<List<EmployeeBO>>{
		@Override
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<EmployeeBO> libos=new ArrayList<EmployeeBO>();
			while(rs.next()) {
				EmployeeBO bo=new EmployeeBO();
				//EMPNO,ENAME,JOB,SALARY,DEPTNO
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getFloat(4));
				bo.setDeptNo(rs.getInt(5));
				libos.add(bo);
			}
			return libos;
		}
		
	}

	

	


}
