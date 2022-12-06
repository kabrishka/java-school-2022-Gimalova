package ru.croc.task17.database;

import java.util.Objects;

public class Order {
    int login_id;
    int vendor_code_id;
    int product_name_id;
    int price_id;

    public Order(int login_id, int vendor_code_id, int product_name_id, int price_id) {
        this.login_id = login_id;
        this.vendor_code_id = vendor_code_id;
        this.product_name_id = product_name_id;
        this.price_id = price_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "login_id=" + login_id +
                ", vendor_code_id=" + vendor_code_id +
                ", product_name_id=" + product_name_id +
                ", price_id=" + price_id +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(login_id, vendor_code_id, product_name_id, price_id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Order order = (Order) obj;
        return login_id == order.login_id
                && vendor_code_id == order.vendor_code_id
                && product_name_id == order.product_name_id
                && price_id == order.price_id;
    }
}