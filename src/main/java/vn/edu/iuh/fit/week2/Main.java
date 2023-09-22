package vn.edu.iuh.fit.week2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.mariadb.jdbc.Driver;
import vn.edu.iuh.fit.week2.db.Connection;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =  Connection.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
    }
}
