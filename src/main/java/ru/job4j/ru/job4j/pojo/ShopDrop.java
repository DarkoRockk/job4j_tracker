package ru.job4j.ru.job4j.pojo;

public class ShopDrop {

    public static Product[] leftShift(Product[] products, int index) {
        for (; index <= products.length - 1; index++) {
            if (index == products.length - 1) {
                products[products.length - 1] = null;
                break;
            }
            products[index] = products[index + 1];
        }
        return products;
    }
}
