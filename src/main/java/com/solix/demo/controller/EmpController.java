package com.solix.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solix.demo.dao.EmpDao;
import com.solix.demo.entity.Employee;
import com.solix.demo.repo.EmpRepo;

@RestController
@RequestMapping(value="/api")
public class EmpController {
	
	@Autowired
	EmpDao empDao;
	
	@Autowired
	EmpRepo emprepo;

		@PostMapping("/savEmp")
		public Employee savEmp(@RequestBody Employee emp) {
			return empDao.saveEmp(emp);
		}
		
		@DeleteMapping("/delEmpById")
		public Optional<Employee> delEmpById(@RequestParam Integer id){
			return empDao.delEmpById(id);
		}
		
		@PutMapping("/updateEmpById")
		public Employee updateEmpById(@RequestParam Integer oldId,@RequestBody Employee newEmployee) {
			return empDao.updateEmpById(oldId, newEmployee);
		}
		
		@GetMapping("/findEmpById")
		public Optional<Employee> findEmpById(@RequestParam Integer id) {
			return empDao.findEmpById(id);
		}
		
		@GetMapping("/findAllEmps")
		public List<Employee> findAllEmps(){
			return empDao.findAllEmps();
		}
	}

