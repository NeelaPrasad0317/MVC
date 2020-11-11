package com.nnp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nnp.bo.UserBO;
import com.nnp.dao.ILoginDAO;
import com.nnp.dto.UserDTO;

@Service
public class LoginServiceImpl implements ILoginService {
	@Autowired
	private ILoginDAO dao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public String checkCredentials(UserDTO dto) {
		UserBO bo=new UserBO();
		BeanUtils.copyProperties(dto, bo);
		return dao.athenticate(bo);
	}

}
