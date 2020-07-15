package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String productName;
    private String type;
    private BigDecimal price;

    private String imagesrc;


    public Products() {

    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", imagesrc='" + imagesrc + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImagesrc() {
        return imagesrc;
    }

    public void setImagesrc(String imagesrc) {
        this.imagesrc = imagesrc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;

        return id == products.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
