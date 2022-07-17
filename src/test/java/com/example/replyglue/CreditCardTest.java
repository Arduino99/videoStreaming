package com.example.replyglue;

import com.example.replyglue.model.CreditCard;
import com.example.replyglue.model.CreditCardValidator;
import com.example.replyglue.model.User;
import com.example.replyglue.model.UserValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class CreditCardTest {
    @BeforeEach
    void beforeTest() {
        creditCard = new CreditCard();
        validator = new CreditCardValidator(creditCard);
    }

    CreditCard creditCard;
    CreditCardValidator validator;

    @Test
    void creditCardisValid() {
        creditCard.setCardNumber("2937394639462937");
        assertTrue("Test1", validator.isCreditCardNumberValid());

        creditCard.setCardNumber("1234");
        assertFalse("Test2",validator.isCreditCardNumberValid());

        creditCard.setCardNumber("vejsjh273h3");
        assertFalse("Test3",validator.isCreditCardNumberValid());
    }
}
