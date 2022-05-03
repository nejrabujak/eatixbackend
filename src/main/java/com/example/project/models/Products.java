package com.example.project.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Products {

   private int barCode;
   private int numOfProd;
    private String name;
    private int price;
    private int date;
    private Rarity rarity;
    private ProductType productType;

}
