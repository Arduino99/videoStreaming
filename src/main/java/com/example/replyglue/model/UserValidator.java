package com.example.replyglue.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class UserValidator {

    private User user;

    public UserValidator(User user) {
        this.user = user;
    }

    public boolean areUserDetailsValid() {
        return
                isPasswordValid() &&
                isEmailValid() &&
                isCreditCardValid();
    }

    public boolean isAbove18() {
        LocalDate userDob = user.getDob();
        LocalDate today = LocalDate.now();

        if (Period.between(userDob, today).getYears() >= 18){
            return true;
        }
        return false;
    }

    public boolean isPasswordValid() {

        Pattern specialCharPattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
        Pattern lowerCasePatten = Pattern.compile("[a-z ]");
        Pattern digitCasePatten = Pattern.compile("[0-9 ]");


        boolean flag = true;

        //Password length must have at least 8 character
        if (user.getPassword().length() < 8) {
            flag = false;
        }
        //Password must have at least one special character
        if (!specialCharPattern.matcher(user.getPassword()).find()) {
            flag = false;
        }
        //Password must have at least one uppercase character
        if (!UpperCasePatten.matcher(user.getPassword()).find()) {
            flag = false;
        }
        //Password can't be all in Capital
        if (!lowerCasePatten.matcher(user.getPassword()).find()) {
            flag = false;
        }
        //Password must have at least one digit character
        if (!digitCasePatten.matcher(user.getPassword()).find()) {
            flag = false;
        }

        return flag;
    }

    public boolean isEmailValid() {
        String pattern= "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return user.getEmail().matches(pattern);
    }

    //Each user might have (or not) a card associated
    public boolean isCreditCardValid() {
        return user.getCardNumber() == null || user.getCardNumber().matches("^[0-9]{16}$");
    }

}
