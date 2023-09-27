package vn.edu.iuh.fit.week2.backend.services;

import vn.edu.iuh.fit.week2.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.week2.backend.models.Employee;
import vn.edu.iuh.fit.week2.backend.repositories.EmployeeRepository;

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

    public Employee findEmployeeById(long id){
        return employeeRepository.findById(id);
    }
}
