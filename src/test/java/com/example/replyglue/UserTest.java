package com.example.replyglue;

import com.example.replyglue.model.User;
import com.example.replyglue.model.UserValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class UserTest {
    @BeforeEach
    void beforeTest() {
        user = new User();
        validator = new UserValidator(user);
    }

    User user;
    UserValidator validator;


    @Test
    void testIsValidPassword() {
        user.setPassword("@rDuino99");
        assertTrue("Test1", validator.isPasswordValid());

        user.setPassword("ardn900ardn"); //no special character
        assertFalse("Test 2", validator.isPasswordValid());

        user.setPassword("@rDuino");     //noNumber
        assertFalse("Test 3", validator.isPasswordValid());

        user.setPassword("arduino");      //too short
        assertFalse("Test 4",validator.isPasswordValid());

        user.setPassword("arduinoo");      //no uppercase
        assertFalse("Test 4",validator.isPasswordValid());




    }

    @Test
    void testIsValidEmail() {
        user.setEmail("arduino@gmail.com");
        assertTrue("Test1", validator.isEmailValid());

        user.setEmail("@.com.gmail");
        assertFalse("Test2", validator.isEmailValid());

        user.setEmail("ard.uino@com");
        assertFalse("Test3", validator.isEmailValid());
    }



    @Test
    void testIsValidDOB() {
        user.setDob(LocalDate.of(1999,02,22));
        assertTrue("Test1", validator.isAbove18());

        user.setDob(LocalDate.of(2022,02,22));
        assertFalse("Test2", validator.isAbove18());
    }

    @Test
    void testIsValidCreditCard() {
        user.setCardNumber("1234567899874564");
        assertTrue("Test1", validator.isCreditCardValid());

        user.setCardNumber("arduino22");
        assertFalse("Test2", validator.isCreditCardValid());

        user.setCardNumber("222222222222");
        assertFalse("Test2", validator.isCreditCardValid());
    }
}
