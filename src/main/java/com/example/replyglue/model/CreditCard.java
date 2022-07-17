package com.example.replyglue.model;

import javax.persistence.*;

@Entity
@Table(name="cards")
public class CreditCard {

    @Id
    @Column(name = "card_number")
    private String cardNumber;

    private String amount;

    public CreditCard() {}

    public CreditCard(String cardNumber, String amount) {
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
