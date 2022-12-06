package ru.croc.task18.entity;

import java.util.Objects;

public class Order {
    private Integer id;
    private Integer login_id;
    private Integer vendor_code_id;
    private Integer product_name_id;
    private Integer price_id;

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLogin_id() {
        return login_id;
    }

    public void setLogin_id(Integer login_id) {
        this.login_id = login_id;
    }

    public Integer getVendor_code_id() {
        return vendor_code_id;
    }

    public void setVendor_code_id(Integer vendor_code_id) {
        this.vendor_code_id = vendor_code_id;
    }

    public Integer getProduct_name_id() {
        return product_name_id;
    }

    public void setProduct_name_id(Integer product_name_id) {
        this.product_name_id = product_name_id;
    }

    public Integer getPrice_id() {
        return price_id;
    }

    public void setPrice_id(Integer price_id) {
        this.price_id = price_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!Objects.equals(id, order.id)) return false;
        if (!Objects.equals(login_id, order.login_id)) return false;
        if (!Objects.equals(vendor_code_id, order.vendor_code_id))
            return false;
        if (!Objects.equals(product_name_id, order.product_name_id))
            return false;
        return Objects.equals(price_id, order.price_id);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login_id != null ? login_id.hashCode() : 0);
        result = 31 * result + (vendor_code_id != null ? vendor_code_id.hashCode() : 0);
        result = 31 * result + (product_name_id != null ? product_name_id.hashCode() : 0);
        result = 31 * result + (price_id != null ? price_id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", login_id=" + login_id +
                ", vendor_code_id=" + vendor_code_id +
                ", product_name_id=" + product_name_id +
                ", price_id=" + price_id +
                '}';
    }
}
