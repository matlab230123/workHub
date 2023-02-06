package com.demo.controller;

import com.demo.entity.EmployeeModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//Bean vs Component vs (Controller, RestController, Service, Repository)
// Spring - Angular has components
//@RestController
@Controller
@RequestMapping("/api/v0")
public class EmployeeController {
   @ResponseBody
    @GetMapping("/employeesHTML")
    protected String getEmployeeWithHTMLAsUI()
            throws ServletException, IOException {
       String htmlOutputString = "<!DOCTYPE html>";
       htmlOutputString += "<html><head><title>Welcome to the Web</title></head>";
       htmlOutputString += "<body><h1>Traditional Web to Spring Web & Spring Boot in future.......</h1>";
       htmlOutputString += "<h1 style='color:red;font-weight: bold;'>";
       htmlOutputString += "Search Screen : Ensures developer productivity!</h1>";
       htmlOutputString += "Enter text to Search :  <input type'text' value=''/>";
       htmlOutputString += "<input type='submit' value='Search'></body></html>";
       return htmlOutputString;
   }
//   @ResponseBody
//   @GetMapping(value = "/employees-list")
//public List getEmployees() {
//       List<EmployeeModel> employeeModelList = new ArrayList<>();
//       employeeModelList.add(new EmployeeModel(1,"Ben",5000));
//       employeeModelList.add(new EmployeeModel(2,"Benny",50000));
//        return employeeModelList;
//   }
}
