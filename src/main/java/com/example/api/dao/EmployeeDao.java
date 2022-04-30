package com.example.api.dao;

import com.example.api.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getEmployees();

    public Employee findById(int employeeId);

    public void save(Employee employee);

    public void deleteById(int employeeId);
}
