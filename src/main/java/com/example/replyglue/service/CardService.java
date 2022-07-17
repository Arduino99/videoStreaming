package com.example.replyglue.service;

import com.example.replyglue.model.CreditCard;
import com.example.replyglue.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<CreditCard> getAllTransactions() {
        return (List<CreditCard>) cardRepository.findAll();
    }

    public void saveCard(CreditCard creditCard) {
        cardRepository.save(creditCard);
    }
}
