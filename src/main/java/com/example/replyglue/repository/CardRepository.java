package com.example.replyglue.repository;

import com.example.replyglue.model.CreditCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<CreditCard, String> {
}
