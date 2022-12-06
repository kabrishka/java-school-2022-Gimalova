package ru.croc.task18.entity;

import java.util.Objects;

public class Product {
    private int id;
    private String vendor_code;
    private String product_name;
    private Integer price;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVendor_code() {
        return vendor_code;
    }

    public void setVendor_code(String vendor_code) {
        this.vendor_code = vendor_code.replaceAll(" ", "");
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name.replaceAll(" ", "_");
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (!Objects.equals(vendor_code, product.vendor_code)) return false;
        if (!Objects.equals(product_name, product.product_name))
            return false;
        return Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (vendor_code != null ? vendor_code.hashCode() : 0);
        result = 31 * result + (product_name != null ? product_name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", vendor_code='" + vendor_code + '\'' +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                '}';
    }
}
