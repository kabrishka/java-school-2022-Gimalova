package ru.croc.task18.service;

import ru.croc.task18.business_logic.Util;
import ru.croc.task18.dao.OrderDAO;
import ru.croc.task18.entity.Product;
import ru.croc.task18.entity.User;
import ru.croc.task18.exceptions.MissingFieldInDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderService extends Util implements OrderDAO {
    Connection connection = getConnection();

    @Override
    public void createOrder(String userLogin, List<Product> products) throws SQLException, MissingFieldInDb {
        ProductService productService = new ProductService();

        //мне нужны только id user и id product, тк в orders находятся внешние ключи
        //пользователь и товары должны быть уже созданы в соотв. таблицах
        String sql = "INSERT INTO Orders (user_id,product_id) VALUES (?,?)";
        String SELECT_USER = "SELECT * FROM Users WHERE login = ?";

        User user = new User();
        try (PreparedStatement stmtUsers = connection.prepareStatement(SELECT_USER)) {
            stmtUsers.setString(1,userLogin);

            ResultSet resultSet = stmtUsers.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
            }
        }

        try (PreparedStatement stmtOrders = connection.prepareStatement(sql)) {
            for(Product product : products) {
                if(productService.findProduct(product.getVendorCode()) == null){
                    throw new MissingFieldInDb();
                }
                stmtOrders.setInt(1,user.getId());
                stmtOrders.setInt(2,product.getId());
                stmtOrders.executeUpdate();
                System.out.println("Insert was successful");
            }
        }
    }
}
