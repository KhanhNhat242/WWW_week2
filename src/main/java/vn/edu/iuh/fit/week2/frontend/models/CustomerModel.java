package vn.edu.iuh.fit.week2.frontend.models;

import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week2.backend.models.Customer;
import vn.edu.iuh.fit.week2.backend.services.CustomerService;

import java.util.List;

public class CustomerModel {
//    @Inject
//    private CustomerService customerService;

    public void insertCust(HttpServletRequest req, HttpServletResponse res){
        CustomerService customerService = new CustomerService();

        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");

        Customer c = new Customer(name, email, phone, address);
        customerService.create(c);

    }

    public List<Customer> getAllCustomer(){
        CustomerService customerService = new CustomerService();
        return customerService.getAll();
    }

    public void updateCust(HttpServletRequest req, HttpServletResponse res){
        CustomerService customerService = new CustomerService();

        Customer c = customerService.findById(Long.parseLong(req.getParameter("id")));

        String address, email, name, phone;
        if(!req.getParameter("address").equals(""))
            c.setAddress(req.getParameter("address"));
        if(!req.getParameter("email").equals(""))
            c.setEmail(req.getParameter("email"));
        if(!req.getParameter("name").equals(""))
            c.setName(req.getParameter("name"));
        if(!req.getParameter("phone").equals(""))
            c.setPhone(req.getParameter("phone"));
        customerService.update(c);
    }

    public  void deleteCust(HttpServletRequest req, HttpServletResponse res){
        CustomerService customerService = new CustomerService();
        long id = Long.parseLong(req.getParameter("deleteId"));
        customerService.delete(id);
    }
}
