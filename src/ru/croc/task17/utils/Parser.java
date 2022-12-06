package ru.croc.task17.utils;

import ru.croc.task17.database.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Parser {
    private static final Map<Integer,Product> products = new HashMap<>();
    private static final Map<Integer,User> users = new HashMap<>();
    private static final Map<Integer,Order> orders = new HashMap<>();


    private static int productId = 1;
    private static int userId = 1;
    private static int orderId = 1;

    public static void parseFromFile(String path) throws IOException, SQLException {
        try(BufferedReader r = new BufferedReader(new FileReader(path))) {
            DBQuery query = new DBQuery(Objects.requireNonNull(DBConnection.getDBConnection()));
            query.deleteDbTable();
            query.createDbTable();
            String line;
            while((line = r.readLine()) != null) {
                String[] record = line.split(",");


                Product product = new Product(record[2],
                        record[3].replaceAll(" ","_"),
                        Integer.parseInt(record[4].replaceAll(" ", "")));
                if(!products.containsValue(product)) {
                    products.put(productId,product);
                    query.insertIntoProducts(product);
                    productId++;
                }

                User user = new User(record[1]);
                if(!users.containsValue(user)) {
                    users.put(userId, user);
                    query.insertIntoUser(user);
                    userId++;
                }

                int currUserId = getKey(users, user);
                int currProductId = getKey(products, product);
                Order order = new Order(currUserId,currProductId,currProductId,currProductId);
                orders.put(orderId, order);
                query.insertIntoOrder(order);
                orderId++;
            }
            query.dbClose();
        }
    }

    //получить ключ по значению
    private static <K, V> K getKey(Map<K, V> map, V value)
    {
        for (Map.Entry<K, V> entry: map.entrySet())
        {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
