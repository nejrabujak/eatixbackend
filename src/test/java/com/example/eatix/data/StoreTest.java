package com.example.eatix.data;

import com.example.eatix.models.Store;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StoreTest {

    public static Store store() {
        Store store = new Store();
        store.setId(1L);
        store.setName("Konzum");
        store.setEmail("konzumIlidza@gmail.com");
        store.setAddress("Mustafe Ice Voljevice 12");
        store.setPhoneNumber("033/852-369");
        store.setCity("Sarajevo");

        return store;
    }
}