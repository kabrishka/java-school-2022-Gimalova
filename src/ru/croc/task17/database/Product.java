package ru.croc.task17.database;

public class Product {
    String vendor_code;
    String product_name;
    int price;

    public Product(String vendor_code, String product_name, int price) {
        this.vendor_code = vendor_code;
        this.product_name = product_name;
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
                && (vendor_code != null && vendor_code.equals(thing.vendor_code))
                && (product_name != null && product_name.equals(thing.product_name));
    }

    @Override
    public String toString() {
        return "Product{" +
                "vendor_code='" + vendor_code + '\'' +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                '}';
    }
}
