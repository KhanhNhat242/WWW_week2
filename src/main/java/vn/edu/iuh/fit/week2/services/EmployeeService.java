package vn.edu.iuh.fit.week2.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.week2.models.Employee;
import vn.edu.iuh.fit.week2.repositories.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(){
        employeeRepository = new EmployeeRepository();
    }

    public Employee add(Employee e){
        employeeRepository.add(e);
        return e;
    }

    public void deleteEmployee(long id, EmployeeStatus es){
        Employee e =  employeeRepository.findById(id);
        e.setStatus(es);
    }

    public Employee updateEmployee(Employee e){
        employeeRepository.update(e);
        return e;
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.getAll();
    }
}
