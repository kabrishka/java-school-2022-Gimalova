package ru.croc.task18.service;

import ru.croc.task18.business_logic.Util;
import ru.croc.task18.dao.ProductDAO;
import ru.croc.task18.entity.Product;
import ru.croc.task18.exceptions.FieldAlreadyExists;
import ru.croc.task18.exceptions.MissingFieldInDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService extends Util implements ProductDAO {
    Connection connection = getConnection();

    @Override
    public Product createProduct(Product product) throws SQLException, FieldAlreadyExists {
        if (findProduct(product.getVendorCode()) != null) {
            throw new FieldAlreadyExists();
        } else {
            String sql = "INSERT INTO products (vendor_code,product_name,price) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1,product.getVendorCode());
                preparedStatement.setString(2,product.getProductName());
                preparedStatement.setInt(3,product.getPrice());
                preparedStatement.executeUpdate();
                System.out.println("Insert was successful");
            }
        }
        return product;
    }

    @Override
    public List<Product> getAll() throws SQLException {
        List<Product> productList = new ArrayList<>();

        String sql = "SELECT id, vendor_code, product_name, price FROM Products";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setVendorCode(resultSet.getString("vendor_code"));
                product.setProductName(resultSet.getString("product_name"));
                product.setPrice(resultSet.getInt("price"));

                productList.add(product);
            }
        }
        return productList;
    }

    @Override
    public Product findProduct(String productCode) throws SQLException {
        String sql = "SELECT * FROM Products WHERE vendor_code = ?";
        System.out.println(productCode);

        Product product = new Product();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,productCode);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                product.setId(resultSet.getInt("id"));
                product.setVendorCode(resultSet.getString("vendor_code"));
                product.setProductName(resultSet.getString("product_name"));
                product.setPrice(resultSet.getInt("price"));
            }
        }
        //в данном случае можно проверить любое поле класса product
        if(product.getVendorCode() == null) {
            return null;
        } else {
            return product;
        }
    }

    @Override
    public Product updateProduct(Product product) throws SQLException, MissingFieldInDb {
        if (findProduct(product.getVendorCode()) == null) {
            throw new MissingFieldInDb();
        } else {
            String sql = "UPDATE Products SET vendor_code = ?, product_name = ?, price = ? WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1,product.getVendorCode());
                preparedStatement.setString(2,product.getProductName());
                preparedStatement.setInt(3,product.getPrice());
                preparedStatement.setInt(4,product.getId());
                preparedStatement.executeUpdate();
            }
        }
        return product;
    }

    @Override
    public void deleteProduct(String productCode) throws SQLException, MissingFieldInDb {
        if(findProduct(productCode) == null) {
            throw new MissingFieldInDb();
        }
        String sql = "DELETE FROM Products WHERE vendor_code = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, productCode);
            preparedStatement.executeUpdate();
            System.out.println("Delete was successful");
        }

    }
}
