package com.example.replyglue.controller;

import com.example.replyglue.model.CreditCard;
import com.example.replyglue.model.CreditCardValidator;
import com.example.replyglue.service.CardService;
import com.example.replyglue.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@Controller
@RequestMapping("/payments")
public class PaymentController {

    CardService cardService;
    UserService userService;

    public PaymentController(CardService cardService, UserService userService) {
        this.cardService = cardService;
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addPayment(@RequestBody CreditCard creditCard) {
        CreditCardValidator validation = new CreditCardValidator(creditCard);

        if (!userService.existsUserByCardNumber(creditCard.getCardNumber())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Credit card not registered with any user. Please check again.");
        }

        if (!validation.isPaymentBasicDetailsValid()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid credit card. Please check again.");
        }

        cardService.saveCard(creditCard);
        return ResponseEntity.created(URI.create("")).body("Payment accepted.");
    }

    @GetMapping("/list")
    public ResponseEntity<Object> getTransactions() {
        return ResponseEntity.accepted().body(cardService.getAllTransactions());
    }

}
