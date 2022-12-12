package ru.croc.task18.dao;

import ru.croc.task18.entity.Product;
import ru.croc.task18.exceptions.FieldAlreadyExists;
import ru.croc.task18.exceptions.MissingFieldInDb;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    //create
    //смысл возвращать продукт, если мы добавляем в таблицу продукт, который передается в параметре
    Product createProduct(Product product) throws SQLException, MissingFieldInDb, FieldAlreadyExists;

    //read
    List<Product> getAll() throws SQLException;

    Product findProduct(String productCode) throws SQLException;

    //update
    Product updateProduct(Product product) throws SQLException, MissingFieldInDb;

    //delete
    void deleteProduct(String productCode) throws SQLException, MissingFieldInDb;
}
