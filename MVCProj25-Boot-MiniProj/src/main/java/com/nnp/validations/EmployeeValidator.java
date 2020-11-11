package com.nnp.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nnp.model.Employee;

@Component("empValidator")
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("\n\nEmployeeValidator.validate()");
		Employee emp=(Employee) target;
		//ename
		if(emp.getEname()==null || emp.getEname().isBlank()) {
			errors.rejectValue("ename", "emp.ename.required");
		}else if(emp.getEname().length()<3 || emp.getEname().length()>10) {
			errors.rejectValue("ename", "emp.ename.length");
		}
		
		//job
		if(emp.getJob()==null || emp.getJob().isBlank())
			errors.rejectValue("job", "emp.job.required");
		else if(emp.getJob().length()<3 || emp.getJob().length()>9) 
			errors.rejectValue("job", "emp.job.length");
		
		//sal
		if(emp.getSal()==null)
			errors.rejectValue("sal", "emp.sal.required");
		else if(emp.getSal().isNaN())
			errors.rejectValue("sal", "emp.sal.typemismatch");
		else if(emp.getSal()<10000 || emp.getSal()>=100000) 
			errors.rejectValue("sal", "emp.sal.range");
	}

}
