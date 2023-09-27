package vn.edu.iuh.fit.week2.backend.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;
    @Column(name = "order_date")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee emp_id;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer cust_id;

    public Order() {
    }

    public Order(Date orderDate, Employee emp_id, Customer cust_id) {
        this.orderDate = orderDate;
        this.emp_id = emp_id;
        this.cust_id = cust_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Employee getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Employee emp_id) {
        this.emp_id = emp_id;
    }

    public Customer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Customer cust_id) {
        this.cust_id = cust_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", emp_id=" + emp_id +
                ", cust_id=" + cust_id +
                '}';
    }
}

