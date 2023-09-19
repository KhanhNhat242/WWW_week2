package vn.edu.iuh.fit.week2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import vn.edu.iuh.fit.week2.db.Connection;
import vn.edu.iuh.fit.week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.week2.models.Employee;

import java.util.List;

public class EmployeeRepository {
    private EntityManagerFactory emf;
    private EntityManager em;

    public EmployeeRepository(){
        emf = Connection.getInstance().getEmf();
        em = emf.createEntityManager();
    }

    public void add(Employee e){
        em.persist(e);
    }

    public void setStatus(Employee e, EmployeeStatus es){
        e.setStatus(es);
    }

    public void update(Employee e){
        em.merge(e);
    }

    public List<Employee> getAllEmployee(){
        String sql = "select * from employee";
        List<Employee> le = em.createNativeQuery(sql, Employee.class).getResultList();
        return le;
    }
}
