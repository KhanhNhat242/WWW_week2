package vn.edu.iuh.fit.week2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import vn.edu.iuh.fit.week2.db.Connection;
import vn.edu.iuh.fit.week2.models.Customer;
import vn.edu.iuh.fit.week2.models.Product;

import java.util.List;

public class CustomerRepository {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public CustomerRepository(){
        emf = Connection.getInstance().getEmf();
        em = emf.createEntityManager();
    }
    
    public void add(Customer c){
        em.persist(c);
    }

    public void delete(long id){
        em.remove(em.find(Customer.class, id));
    }

    public void update(Customer c){
        em.merge(c);
    }
    
    public List<Customer> getAllCustomer(){
        String sql = "select * from customer";
        List<Customer> lc = em.createNativeQuery(sql, Customer.class).getResultList();
        return lc;
    }
}
