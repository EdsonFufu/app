package com.example.test.app.controllers;

import com.example.test.app.models.Agent;
import com.example.test.app.models.Employee;
import com.example.test.app.repository.AgentRepository;
import com.example.test.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @PostMapping("/employee/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeRepository.save(employee));
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        return ResponseEntity.ok(employeeRepository.findById(id).orElse(null));
    }
    @GetMapping("/employee/")
    public ResponseEntity<List<Employee>> getEmployees(){
        return ResponseEntity.ok(employeeRepository.findAll());
    }
}
