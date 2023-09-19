package vn.edu.iuh.fit.week2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import vn.edu.iuh.fit.week2.db.Connection;
import vn.edu.iuh.fit.week2.models.Order;

import java.util.List;

public class OrderRepository {
    private EntityManagerFactory emf;
    private EntityManager em;

    public OrderRepository(){
        emf = Connection.getInstance().getEmf();
        em = emf.createEntityManager();
    }

    public void add(Order o){
        em.persist(o);
    }

    public void delete(long id){
        em.remove(em.find(Order.class, id));
    }

    public void update(Order o){
        em.merge(o);
    }

    public List<Order> getAll(){
        String sql = "select * from order";
        List<Order> lo = em.createNativeQuery(sql, Order.class).getResultList();
        return lo;
    }
}
