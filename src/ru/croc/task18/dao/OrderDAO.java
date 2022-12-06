package ru.croc.task18.dao;

import ru.croc.task18.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {
    //create
    //с моей реализацией невозможно вернуть order, если мы передаем list<product>,
    //тк создается n-е кол-во order'ов равное кол-ву элементов в list
    void createOrder(String userLogin, List<Product> products) throws SQLException;

}
