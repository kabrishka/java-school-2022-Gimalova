package ru.croc.task17.database;

public class Product {
    String vendorCode;
    String productName;
    int price;

    public Product(String vendorCode, String productName, int price) {
        this.vendorCode = vendorCode;
        this.productName = productName;
        this.price = price;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Product thing = (Product) obj;
        return price == thing.price
                && (vendorCode != null && vendorCode.equals(thing.vendorCode))
                && (productName != null && productName.equals(thing.productName));
    }

    @Override
    public String toString() {
        return "Product{" +
                "vendorCode='" + vendorCode + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
