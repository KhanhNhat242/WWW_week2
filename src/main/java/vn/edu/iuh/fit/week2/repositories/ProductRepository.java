package vn.edu.iuh.fit.week2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import vn.edu.iuh.fit.week2.db.Connection;
import vn.edu.iuh.fit.week2.models.Product;

import java.util.List;

public class ProductRepository {
    private EntityManagerFactory emf;
    private EntityManager em;

    public ProductRepository(){
        emf = Connection.getInstance().getEmf();
        em = emf.createEntityManager();
    }

    public void add(Product p){
        em.persist(p);
    }

    public void delete(long id){
        em.remove(em.find(Product.class, id));
    }

    public void update(Product p){
        em.merge(p);
    }

    public List<Product> getAll(){
        String sql = "select * from product";
        List<Product> lp = em.createNativeQuery(sql, Product.class).getResultList();
        return lp;
    }
}
