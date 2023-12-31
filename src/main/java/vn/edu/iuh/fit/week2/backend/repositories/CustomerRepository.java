package vn.edu.iuh.fit.week2.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.week2.backend.db.Connection;
import vn.edu.iuh.fit.week2.backend.models.Customer;

import java.util.List;

public class CustomerRepository {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tr;
    public CustomerRepository(){
        emf = Connection.getInstance().getEmf();
        em = emf.createEntityManager();
        tr = em.getTransaction();
    }
    
    public void add(Customer c){
        tr.begin();
        try {
            em.persist(c);
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }

    public void delete(long id){
        tr.begin();
        try {
            em.remove(em.find(Customer.class, id));
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }

    public void update(Customer c){
        tr.begin();
        try {
            em.merge(c);
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }
    
    public List<Customer> getAllCustomer(){
        String sql = "select * from customer";
        List<Customer> lc = em.createNativeQuery(sql, Customer.class).getResultList();
        return lc;
    }

    public Customer findById(long id){
        String sql = "select * from customer where id = "+ id;
        Customer c = (Customer) em.createNativeQuery(sql, Customer.class).getSingleResult();
        return c;
    }
}
