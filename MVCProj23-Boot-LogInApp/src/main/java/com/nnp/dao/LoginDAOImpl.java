package com.nnp.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nnp.bo.UserBO;

@Repository
public class LoginDAOImpl implements ILoginDAO{
	@Autowired
	private SimpleJdbcCall sjc;
	
	
	@Override
	public String athenticate(UserBO bo) {
		Map<String,String> map=null;
		map=Map.of("USERID",bo.getUname(),"PASS",bo.getPwd());
		
		sjc.setProcedureName("P_ATHENTICATION");
		
		Map<String, Object> rs= sjc.execute(map);
		System.out.println(rs.get("MSG"));
		return (String) rs.get("MSG");
	}

}
