package com.nnp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nnp.dto.StudentDTO;

@Service
public class StudentMgmtService {
	public List<StudentDTO> getAllStudents(){
		return List.of(new StudentDTO(101, "nnp", "ctg", 91.00f), 
							new StudentDTO(102, "neela", "hyd", 100.0f),
							new StudentDTO(103, "prasad", "chennai", 72.75f),
							new StudentDTO(104, "nsp", "ctg", 98.02F));
	}
}
