package vn.edu.iuh.fit.week2.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.week2.backend.db.Connection;
import vn.edu.iuh.fit.week2.backend.models.Order;

import java.util.List;

public class OrderRepository {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tr;

    public OrderRepository(){
        emf = Connection.getInstance().getEmf();
        em = emf.createEntityManager();
        tr = em.getTransaction();
    }

    public void add(Order o){
        tr.begin();
        try {
            em.persist(o);
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
            em.remove(em.find(Order.class, id));
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }

    public void update(Order o){
        tr.begin();
        try {
            em.merge(o);
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }

    public List<Order> getAll(){
        String sql = "select * from order";
        List<Order> lo = em.createNativeQuery(sql, Order.class).getResultList();
        return lo;
    }
}
