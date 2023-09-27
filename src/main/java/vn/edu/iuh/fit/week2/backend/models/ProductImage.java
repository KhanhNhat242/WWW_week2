package vn.edu.iuh.fit.week2.backend.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "product_image")
public class ProductImage implements Serializable{
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long image_id;
    private String path;
    private String alternative;

    public ProductImage() {
    }

    public ProductImage(String path, String alternative) {
        this.path = path;
        this.alternative = alternative;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public long getImage_id() {
        return image_id;
    }

    public void setImage_id(long image_id) {
        this.image_id = image_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "product_id=" + product_id +
                ", image_id=" + image_id +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                '}';
    }
}
