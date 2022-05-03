package com.example.project.controllers;

import com.eatix.models.ProductType;
import com.eatix.models.Products;
import com.eatix.models.Rarity;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {
    private List<Products> finalList;

    public ProductController() {
        finalList = new ArrayList<>();
        finalList.add(generateFood());
        finalList.add(generateDrinks());
    }

    @GetMapping

    public List<Products> getProducts(){

        return finalList;
}
@GetMapping("/barCode")

    public Products getProducts(int barCode){
        for(Products products : finalList){
            if(products.getBarCode() == barCode){
                return products;
            }


        return null;
}
        @GetMapping("/numOfProd")

    public Products getProducts(int numOfProd){
        for(Products products : finalList){
            if(products.getBarCode() == numOfProd){
                return products;
            }


        return null;
}
        @GetMapping("/price")

    public Products getProducts(int price){
        for(Products products : finalList){
            if(products.getBarCode() == price){
                return products;
            }


        return null;
}@GetMapping("/date")

    public Products getProducts(int date){
        for(Products products : finalList){
            if(products.getBarCode() == date){
                return products;
            }


        return null;
}

    private Products generateFood() {
        Products products = new Products();
        products.setName("apple");
        products.getBarCode(25);

        products.setRarity(Rarity.fresh);
        products.setProductType(ProductType.food);
        return products;
    }
    private Products generateDrinks() {
        Products products = new Products();
        products.setName("water");
        products.getBarCode(25254844);

        products.setRarity(Rarity.fresh);
        products.setProductType(ProductType.drinks);
        return products;
    }

}



}
