package com.nnp.service;

import com.nnp.dto.UserDTO;

public interface ILoginService {
	String checkCredentials(UserDTO dto);
}
