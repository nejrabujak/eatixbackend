package com.example.eatix.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import javax.persistence.*;

@Entity
@Table(name = "app_product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "store", referencedColumnName = "id")
    private Store store;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "expiring_date")
    private String expiringDate;

    @Column(name = "price")
    private String price;
}