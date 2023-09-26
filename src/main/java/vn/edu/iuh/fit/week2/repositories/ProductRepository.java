package vn.edu.iuh.fit.week2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.week2.db.Connection;
import vn.edu.iuh.fit.week2.models.Product;

import java.util.List;

public class ProductRepository {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tr;

    public ProductRepository(){
        emf = Connection.getInstance().getEmf();
        em = emf.createEntityManager();
        tr = em.getTransaction();
    }

    public void add(Product p){
        tr.begin();
        try {
            em.persist(p);
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
            em.remove(em.find(Product.class, id));
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }

    public void update(Product p){
        tr.begin();
        try {
            em.merge(p);
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }

    public List<Product> getAll(){
        String sql = "select * from product";
        List<Product> lp = em.createNativeQuery(sql, Product.class).getResultList();
        return lp;
    }
}
