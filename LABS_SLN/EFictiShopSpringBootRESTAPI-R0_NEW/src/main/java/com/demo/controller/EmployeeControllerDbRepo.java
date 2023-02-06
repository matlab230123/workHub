package com.demo.controller;

import com.demo.entity.EmployeeEntity;
import com.demo.entity.EmployeeModel;
import com.demo.exception.EmployeeException;
import com.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class EmployeeControllerDbRepo {
//    FIELD BASED DI
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List getEmployees(){
        System.out.println("All Emp From Repo");
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeModel employeeFromClient) throws Exception {
        Optional<EmployeeEntity> byName = employeeRepository.findByName(employeeFromClient.getName());
        if(byName.isPresent()){
            throw new EmployeeException("Employee already exist in the DB!!!");
        }
        EmployeeEntity entity = new EmployeeEntity();
        entity.setName(employeeFromClient.getName());
        entity.setSalary(employeeFromClient.getSalary());
        return new ResponseEntity<>(employeeRepository.save(entity), HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeModel model, @PathVariable int id) throws Exception {
        Optional<EmployeeEntity> byId = employeeRepository.findById(id);
        if(byId.isEmpty()){
            throw new Exception("No Employee found by the given id: "+ id);
        }
        byId.get().setName(model.getName());
        byId.get().setSalary(model.getSalary());

        return  new ResponseEntity<>(employeeRepository.save(byId.get()), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) throws Exception {
        Optional<EmployeeEntity> byId = employeeRepository.findById(id);
        if(byId.isEmpty()){
            throw new Exception("No Employee found by the given id: "+ id);
        }
        employeeRepository.deleteById(id);
        return new ResponseEntity<>("Actor successfully deleted", HttpStatus.OK);
    }


//    US LAB : CODE THE UPDATE FUNCTIONALITY
//    "/employees" = fixed path
//    "{id}" = variable
//    /employees/1 passed in url
//    pass the details to be updated in the body.
//    @PutMapping("/employees/{id}")
//public EmployeeEntity updateEmployee(.......) {
//        return the updated employee
//}

    //  US  LAB : CODE THE DELETE FUNCTIONALITY
//    "/employees" = fixed path
//    "{id}" = variable
//    /employees/1 passed in url
//    pass the details to be updated in the body.
//    @PutMapping("/employees/{id}")
//public EmployeeEntity deleteEmployeeById(.......) {
//        return the deleted employee
//}
}
