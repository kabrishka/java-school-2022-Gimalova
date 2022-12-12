package ru.croc.task17.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DBQuery implements AutoCloseable{
    private final Connection dbConnection;
    private final Statement statement;
    private PreparedStatement preparedStatement;

    public DBQuery(Connection dbConnection) {
        this.dbConnection = dbConnection;
        try {
            this.statement = dbConnection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (statement != null) {
            statement.close();
        }
        if (dbConnection != null) {
            dbConnection.close();
        }
    }

    public void createDbTable() {
        String CREATE_PRODUCTS_QUERY = "CREATE TABLE IF NOT EXISTS Products("
                + "ID INTEGER PRIMARY  KEY NOT NULL AUTO_INCREMENT, "
                + "VENDOR_CODE VARCHAR(20), "
                + "PRODUCT_NAME CHARACTER VARYING(30), "
                + "PRICE INTEGER"
                + ")";
        String CREATE_USERS_QUERY = "CREATE TABLE IF NOT EXISTS Users("
                + "ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, "
                + "LOGIN VARCHAR(20) "
                + ")";

        String CREATE_ORDERS_QUERY = "CREATE TABLE IF NOT EXISTS Orders("
                + "ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, "
                + "USER_ID INTEGER, "
                + "PRODUCT_ID INTEGER, "
                + "FOREIGN KEY (USER_ID) REFERENCES Users(ID),"
                + "FOREIGN KEY (PRODUCT_ID) REFERENCES Products(ID)"
                + ")";

        try {
            // выполнить SQL запрос
            statement.execute(CREATE_PRODUCTS_QUERY);
            System.out.println("Table \"dbproducts\" is created!");
            statement.execute(CREATE_USERS_QUERY);
            System.out.println("Table \"dbusers\" is created!");
            statement.execute(CREATE_ORDERS_QUERY);
            System.out.println("Table \"dborders\" is created!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDbTable() {
        String DELETE_ORDERS_QUERY = "DROP TABLE IF EXISTS Orders";
        String DELETE_PRODUCTS_QUERY = "DROP TABLE IF EXISTS Products";
        String DELETE_USERS_QUERY = "DROP TABLE IF EXISTS Users";
        try {
            statement.execute(DELETE_ORDERS_QUERY);
            System.out.println("Table \"dborders\" is deleted!");
            statement.execute(DELETE_PRODUCTS_QUERY);
            System.out.println("Table \"dbproducts\" is deleted!");
            statement.execute(DELETE_USERS_QUERY);
            System.out.println("Table \"dbusers\" is deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertIntoProducts(Product product) {
        String INSERT_PRODUCTS_QUERY = "INSERT INTO products (vendor_code,product_name,price) VALUES (?, ?, ?)";
        try {
            preparedStatement = dbConnection.prepareStatement(INSERT_PRODUCTS_QUERY);
            preparedStatement.setString(1,product.vendorCode);
            preparedStatement.setString(2,product.productName);
            preparedStatement.setInt(3,product.price);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertIntoUser(User user) {
        String INSERT_USERS_QUERY = "INSERT INTO users (login) VALUES (?)";
         try {
             preparedStatement = dbConnection.prepareStatement(INSERT_USERS_QUERY);
             preparedStatement.setString(1, user.login);
             preparedStatement.executeUpdate();
         } catch (SQLException e) {
            e.printStackTrace();
         }
    }

    public void insertIntoOrder(Order order) {
        String INSERT_ORDERS_QUERY = "INSERT INTO Orders (user_id,product_id) VALUES (?,?)";
         try {
             preparedStatement = dbConnection.prepareStatement(INSERT_ORDERS_QUERY);
             preparedStatement.setInt(1,order.userId);
             preparedStatement.setInt(2,order.productId);
             preparedStatement.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
}
