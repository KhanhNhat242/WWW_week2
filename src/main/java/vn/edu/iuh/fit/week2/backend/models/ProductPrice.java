package vn.edu.iuh.fit.week2.backend.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "product_price")
//@IdClass(ProductPrice.IdDateTimePK.class)
public class ProductPrice implements Serializable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product_id;
    @Id
    private Date price_date_time;
    @Column(columnDefinition = "float")
    private double price;
    private String note;

    public ProductPrice() {
    }

    public ProductPrice(Date price_date_time, double price, String note) {
        this.price_date_time = price_date_time;
        this.price = price;
        this.note = note;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public Date getPrice_date_time() {
        return price_date_time;
    }

    public void setPrice_date_time(Date price_date_time) {
        this.price_date_time = price_date_time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "product_id=" + product_id +
                ", price_date_time=" + price_date_time +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
