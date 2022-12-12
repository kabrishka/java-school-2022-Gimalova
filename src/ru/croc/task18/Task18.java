package ru.croc.task18;

import ru.croc.task18.entity.Product;
import ru.croc.task18.exceptions.FieldAlreadyExists;
import ru.croc.task18.exceptions.MissingFieldInDb;
import ru.croc.task18.service.OrderService;
import ru.croc.task18.service.ProductService;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Task18 {
    public static void main(String[] args) throws SQLException, MissingFieldInDb, FieldAlreadyExists {
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();

        Product jacketForProgrammer = new Product(); //кружка для программиста
        jacketForProgrammer.setId(6);
        jacketForProgrammer.setVendorCode("Т6");
        jacketForProgrammer.setProductName("Кружка для программиста");
        jacketForProgrammer.setPrice(70);
        productService.createProduct(jacketForProgrammer);

        System.out.println("============================================================");
        Product newJacketForProgrammer = new Product(); //кружка для программиста
        newJacketForProgrammer.setId(6);
        newJacketForProgrammer.setVendorCode("Т6");
        newJacketForProgrammer.setProductName("Кружка для программиста NEW!!!");
        newJacketForProgrammer.setPrice(10000);
        productService.updateProduct(newJacketForProgrammer);

        System.out.println("============================================================");

        Product tablet = new Product(); //планшет
        tablet.setId(7);
        tablet.setVendorCode("Т7");
        tablet.setProductName("Планшет");
        tablet.setPrice(60);
        productService.createProduct(tablet);

        System.out.println("============================================================");

        Product productToDelete = new Product();
        productToDelete.setId(8);
        productToDelete.setVendorCode("Т8");
        productToDelete.setProductName("delete");
        productToDelete.setPrice(0);
        productService.createProduct(productToDelete);

        System.out.println("============================================================");

        for(Product product : productService.getAll()) {
            System.out.println(product);
        }

        System.out.println("============================================================");

        System.out.println("We found : " + productService.findProduct("Т10"));

        System.out.println("============================================================");

        productService.deleteProduct("Т8");

        System.out.println("============================================================");

        List<Product> products = Arrays.asList(jacketForProgrammer, tablet);
        orderService.createOrder("vasya",products);

        System.out.println("============================================================");

        Product wrongProduct = new Product();
        wrongProduct.setId(12);
        wrongProduct.setVendorCode("Т6");
        wrongProduct.setProductName("wrong");
        wrongProduct.setPrice(0);
        productService.createProduct(wrongProduct);

        System.out.println("============================================================");
        Product wrongProduct1 = new Product();
        wrongProduct1.setId(12);
        wrongProduct1.setVendorCode("Т101");
        wrongProduct1.setProductName("wrong");
        wrongProduct1.setPrice(0);
        productService.updateProduct(wrongProduct1);

    }
}
