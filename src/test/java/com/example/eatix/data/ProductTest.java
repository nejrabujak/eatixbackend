package com.example.eatix.data;

import com.example.eatix.models.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductTest {

    public static Product product() {

        Product product = new Product();
        product.setId(2L);
        product.setName("Apple");
        product.setType("fruit");
        product.setExpiringDate("15.10.2022");
        product.setPrice(2.00);

        return product;
    }
}
