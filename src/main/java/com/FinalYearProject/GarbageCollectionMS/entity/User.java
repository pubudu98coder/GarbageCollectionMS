package com.FinalYearProject.GarbageCollectionMS.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String fName;

    @Column(nullable = false)
    private String lName;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    // getters, setters, other methods
}

