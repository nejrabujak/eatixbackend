package com.example.project.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
public class Users {
    long id;
    String name;
    String surname;
    String mail;
    String password;

}
