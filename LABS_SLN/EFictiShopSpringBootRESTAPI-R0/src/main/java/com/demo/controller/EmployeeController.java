package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.io.IOException;

@RestController
@RequestMapping("/api/v0")
public class EmployeeController {
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
}
