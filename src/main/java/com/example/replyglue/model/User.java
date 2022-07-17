package com.example.replyglue.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @Pattern(regexp = "[^\\s]") //REGEX that checks no white spaces in the String
    @Size(min = 4, max = 16)
    @Column(name = "username", unique = true)
    //Username - alphanumeric, no spaces
    private String username;

    @NotNull
    @Size(min = 8)
    //Password – min length 8, at least one upper case letter & number
    private String password;

    @NotNull
    @Column(unique = true)
    //Email – email id with email format
    private String email;

    @NotNull
    //DoB (Date of Birth) - ISO 8601 format
    private LocalDate dob;

    //Credit Card Number – This field is optional. If given should have 16 digits
    @Column(unique = true, name = "credit_card")
    private String cardNumber;

    //     Credit Card Number – This field is optional. If given should have 16 digits
    public User() {}

    public User(String username, String password, String email, LocalDate dob) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dob = dob;
    }

    public User(String username, String password, String email, LocalDate dob, String cardNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.cardNumber = cardNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


