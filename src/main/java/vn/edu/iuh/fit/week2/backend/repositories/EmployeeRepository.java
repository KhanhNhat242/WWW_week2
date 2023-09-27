package vn.edu.iuh.fit.week2.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.week2.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.week2.backend.models.Employee;
import vn.edu.iuh.fit.week2.backend.db.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EmployeeRepository {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tr;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public EmployeeRepository(){
        emf = Connection.getInstance().getEmf();
        em = emf.createEntityManager();
        tr = em.getTransaction();
    }

    public void add(Employee e){
        tr.begin();
        try {
            em.persist(e);
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }

    public void setStatus(Employee e, EmployeeStatus es){
        e.setStatus(es);
    }

    public void update(Employee e){
        tr.begin();
        try {
            em.merge(e);
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }

    public Employee findById(long id){
        String sql = "select * from employee where emp_id like '"+id+"'";
        Employee e = (Employee) em.createNativeQuery(sql, Employee.class).getSingleResult();
        return e;
    }

    public List<Employee> getAll(){
        String sql = "select * from employee";
        List<Employee> le = em.createNativeQuery(sql, Employee.class).getResultList();
        return le;
    }
}
