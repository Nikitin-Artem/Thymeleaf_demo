package com.example.api.dao;

import com.example.api.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getEmployees() {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int employeeId) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        Employee employee = currentSession.get(Employee.class, employeeId);

        return employee;
    }

    @Override
    public void save(Employee employee) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(employee); // if id = 0 then save, else update
    }

    @Override
    public void deleteById(int employeeId) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        Query query = currentSession.createQuery("delete from Employee where id=:theId");

        query.setParameter("theId", employeeId);

        query.executeUpdate();
    }
}
