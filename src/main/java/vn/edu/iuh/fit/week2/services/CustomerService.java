package vn.edu.iuh.fit.week2.services;

import vn.edu.iuh.fit.week2.models.Customer;
import vn.edu.iuh.fit.week2.repositories.CustomerRepository;

import java.util.List;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService() {
        customerRepository = new CustomerRepository();
    }

    public List<Customer> getAll(){
        return customerRepository.getAllCustomer();
    }

    public Customer create(Customer c){
        customerRepository.add(c);
        return c;
    }

    public void delete(long id){
        customerRepository.delete(id);
    }

    public Customer update(Customer c){
        customerRepository.update(c);
        return c;
    }
}
