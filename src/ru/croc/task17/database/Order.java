package ru.croc.task17.database;

import java.util.Objects;

public class Order {
    int userId;
    int productId;

    public Order(int userId, int productId) {
        this.userId = userId;
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "loginId=" + userId +
                ", productId=" + productId +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, productId);}

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Order order = (Order) obj;
        return userId == order.userId
                && productId == order.productId;
    }
}