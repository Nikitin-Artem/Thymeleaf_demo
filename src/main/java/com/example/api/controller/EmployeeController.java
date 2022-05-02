package com.example.api.controller;


import com.example.api.entity.Employee;
import com.example.api.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // @Autowired is required if more than one constructor, but we can still use it
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // List of all Employees
    @GetMapping("/list")
    public String listEmployees(Model model) {

        // get employees from database
        List<Employee> employees = employeeService.findAll();

        // add to the spring model
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    // Go to 'Add new Employee' form
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Employee theEmployee = new Employee();

        model.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    // Update existing Employee
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){

        // get the employee from the service
        Employee theEmployee = employeeService.findById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    // Saving new Employee to database
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee thEmployee){

        employeeService.save(thEmployee);

        // use a redirect to prevent duplicate submission
        return "redirect:/employees/list";
    }

    // Deleting Employee from database
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId){

        employeeService.deleteById(theId);

        return "redirect:/employees/list";
    }

    @GetMapping("/search")
    public String delete(@RequestParam("employeeName") String theName,
                         Model theModel) {

        // delete the employee
        List<Employee> theEmployees = employeeService.searchBy(theName);

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "/employees/list-employees";
    }
}
