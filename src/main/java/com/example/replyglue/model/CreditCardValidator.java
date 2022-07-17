package com.example.replyglue.model;

public class CreditCardValidator {

    private CreditCard creditCard;

    public CreditCardValidator(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public boolean isPaymentBasicDetailsValid() {
        return isCreditCardNumberValid() && isAmountValid();
    }

    public boolean isCreditCardNumberValid() {
        return creditCard.getCardNumber().matches("^[0-9]{16}$");
    }

    public boolean isAmountValid() {
        try {
            int amount = Integer.parseInt(creditCard.getAmount());
            if (creditCard.getAmount().length() == 3 && amount > 99 && amount < 1000) {
                return true;
            }
        }
        catch(NumberFormatException e) {}
        return false;
    }
}
