package ru.croc.task18.service;

import ru.croc.task18.business_logic.Util;
import ru.croc.task18.dao.ProductDAO;
import ru.croc.task18.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService extends Util implements ProductDAO {
    Connection connection = getConnection();

    @Override
    public Product createProduct(Product product) throws SQLException {
        String sql = "INSERT INTO products (vendor_code,product_name,price) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,product.getVendor_code());
            preparedStatement.setString(2,product.getProduct_name());
            preparedStatement.setInt(3,product.getPrice());
            preparedStatement.executeUpdate();
            System.out.println("Insert was successful");
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
                product.setVendor_code(resultSet.getString("vendor_code"));
                product.setProduct_name(resultSet.getString("product_name"));
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
                product.setVendor_code(resultSet.getString("vendor_code"));
                product.setProduct_name(resultSet.getString("product_name"));
                product.setPrice(resultSet.getInt("price"));
            }
        }
        return product;
    }

    @Override
    public Product updateProduct(Product product) throws SQLException {
        String sql = "UPDATE Products SET vendor_code = ?, product_name = ?, price = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,product.getVendor_code());
            preparedStatement.setString(2,product.getProduct_name());
            preparedStatement.setInt(3,product.getPrice());
            preparedStatement.setInt(4,product.getId());
            preparedStatement.executeUpdate();
        }
        return product;
    }

    @Override
    public void deleteProduct(String productCode) throws SQLException {
        String sql = "DELETE FROM Products WHERE vendor_code = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, productCode);
            preparedStatement.executeUpdate();
            System.out.println("Delete was successful");
        }

    }
}
