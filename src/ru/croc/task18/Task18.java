package ru.croc.task18;

import ru.croc.task18.entity.Product;
import ru.croc.task18.service.OrderService;
import ru.croc.task18.service.ProductService;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Task18 {
    public static void main(String[] args) throws SQLException {
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();

        Product jacketForProgrammer = new Product(); //кружка для программиста
        jacketForProgrammer.setId(6);
        jacketForProgrammer.setVendor_code("Т6");
        jacketForProgrammer.setProduct_name("Кружка для программиста");
        jacketForProgrammer.setPrice(70);
        productService.createProduct(jacketForProgrammer);

        System.out.println("============================================================");

        Product tablet = new Product(); //планшет
        tablet.setId(7);
        tablet.setVendor_code("Т7");
        tablet.setProduct_name("Планшет");
        tablet.setPrice(60);
        productService.createProduct(tablet);

        System.out.println("============================================================");

        Product productToDelete = new Product();
        productToDelete.setId(8);
        productToDelete.setVendor_code("Т8");
        productToDelete.setProduct_name("delete");
        productToDelete.setPrice(0);
        productService.createProduct(productToDelete);

        System.out.println("============================================================");

        for(Product product : productService.getAll()) {
            System.out.println(product);
        }

        System.out.println("============================================================");

        System.out.println("We found : " + productService.findProduct("Т7"));

        System.out.println("============================================================");

        productService.deleteProduct("Т8");

        System.out.println("============================================================");

        List<Product> products = Arrays.asList(jacketForProgrammer, tablet);
        orderService.createOrder("vasya",products);
    }



}
