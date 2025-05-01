package com.solix.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solix.demo.entity.Employee;
import com.solix.demo.repo.EmpRepo;

@Service
public class EmpDao {
	
	@Autowired
	EmpRepo emprepo;
	
	public Employee saveEmp(Employee emp) {
		return emprepo.save(emp);
	}
	
	public Optional<Employee> delEmpById(Integer id){
		Optional<Employee>	emp=emprepo.findById(id);
		emprepo.deleteById(id);
		return emp;
	}
	
	public Employee updateEmpById(Integer oldId, Employee newEmployee) {
		newEmployee.setEmpId(oldId);
		return emprepo.save(newEmployee);
	}
	
	public Optional<Employee> findEmpById(Integer id) {
		return emprepo.findById(id);
	}
	
	public List<Employee> findAllEmps(){
		return emprepo.findAll();
	}

}
