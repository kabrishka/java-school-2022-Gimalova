package ru.croc.task18.entity;

import java.util.Objects;

public class Product {
    private int id;
    private String vendorCode;
    private String productName;
    private Integer price;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode.replaceAll(" ", "");
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName.replaceAll(" ", "_");
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
        if (!Objects.equals(vendorCode, product.vendorCode)) return false;
        if (!Objects.equals(productName, product.productName))
            return false;
        return Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (vendorCode != null ? vendorCode.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", vendor_code='" + vendorCode + '\'' +
                ", product_name='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
