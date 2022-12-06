package ru.croc.task17.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DBQuery {
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

    public void createDbTable() {
        String CREATE_PRODUCTS_QUERY = "CREATE TABLE IF NOT EXISTS Products("
                + "ID INTEGER NOT NULL PRIMARY  KEY, "
                + "VENDOR_CODE VARCHAR(20), "
                + "PRODUCT_NAME CHARACTER VARYING(30), "
                + "PRICE INTEGER"
                + ")";
        String CREATE_USERS_QUERY = "CREATE TABLE IF NOT EXISTS Users("
                + "ID INTEGER NOT NULL PRIMARY KEY, "
                + "LOGIN VARCHAR(20) "
                + ")";

        String CREATE_ORDERS_QUERY = "CREATE TABLE IF NOT EXISTS Orders("
                + "ID INTEGER NOT NULL PRIMARY KEY, "
                + "LOGIN_ID INTEGER NOT NULL, "
                + "VENDOR_CODE_ID INTEGER NOT NULL, "
                + "PRODUCT_NAME_ID INTEGER NOT NULL, "
                + "PRICE_ID INTEGER NOT NULL,"
                + "FOREIGN KEY (LOGIN_ID) REFERENCES Users(ID),"
                + "FOREIGN KEY (VENDOR_CODE_ID) REFERENCES Products(ID),"
                + "FOREIGN KEY (PRODUCT_NAME_ID) REFERENCES Products(ID),"
                + "FOREIGN KEY (PRICE_ID) REFERENCES Products(ID)"
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
    }
    public void dbClose() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (dbConnection != null) {
            dbConnection.close();
        }
    }

    public void insertIntoProducts(Integer id,Product product) {
        String INSERT_PRODUCTS_QUERY = "INSERT INTO products (id,vendor_code,product_name,price) VALUES (?, ?, ?, ?)";
        try {
            preparedStatement = dbConnection.prepareStatement(INSERT_PRODUCTS_QUERY);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,product.vendor_code);
            preparedStatement.setString(3,product.product_name);
            preparedStatement.setInt(4,product.price);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertIntoUser(Integer id, User user) {
        String INSERT_USERS_QUERY = "INSERT INTO users (id, login) VALUES (?, ?)";
         try {
             preparedStatement = dbConnection.prepareStatement(INSERT_USERS_QUERY);
             preparedStatement.setInt(1, id);
             preparedStatement.setString(2, user.login);
             preparedStatement.executeUpdate();
         } catch (SQLException e) {
            e.printStackTrace();
         }
    }

    public void insertIntoOrder(Integer id, Order order) {
        String INSERT_ORDERS_QUERY = "INSERT INTO Orders (id,login_id,vendor_code_id,product_name_id,price_id) VALUES (?,?,?,?,?)";
         try {
             preparedStatement = dbConnection.prepareStatement(INSERT_ORDERS_QUERY);
             preparedStatement.setInt(1,id);
             preparedStatement.setInt(2,order.login_id);
             preparedStatement.setInt(3,order.vendor_code_id);
             preparedStatement.setInt(4,order.product_name_id);
             preparedStatement.setInt(5,order.price_id);
             preparedStatement.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
}
