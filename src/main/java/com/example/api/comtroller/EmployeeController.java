package com.example.api.comtroller;

import com.example.api.entity.Employee;
import com.example.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;


    // @Autowired is required if more than one constructor, but we can still use it
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){

        // get employees from database
        List<Employee> employees = employeeService.getEmployees();

        // add to the spring model
        model.addAttribute("employees", employees);

        return "list-employees";
    }
}
