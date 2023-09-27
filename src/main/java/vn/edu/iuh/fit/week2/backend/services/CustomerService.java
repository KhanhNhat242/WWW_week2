package vn.edu.iuh.fit.week2.backend.services;

import vn.edu.iuh.fit.week2.backend.models.Customer;
import vn.edu.iuh.fit.week2.backend.repositories.CustomerRepository;

import java.util.List;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService() {
        customerRepository = new CustomerRepository();
    }

    public List<Customer> getAll(){
        return customerRepository.getAllCustomer();
    }

    public void create(Customer c){
        customerRepository.add(c);
    }

    public void delete(long id){
        customerRepository.delete(id);
    }

    public void update(Customer c){
        customerRepository.update(c);
    }

    public Customer findById(long id){
        return customerRepository.findById(id);
    }
}
