package vn.edu.iuh.fit.week2.models;

import jakarta.persistence.*;

@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

}
