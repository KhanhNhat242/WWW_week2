package vn.edu.iuh.fit.week2.backend.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.week2.backend.db.Connection;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =  Connection.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        tr.begin();

        try {
            tr.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            tr.rollback();
        }
    }
}
