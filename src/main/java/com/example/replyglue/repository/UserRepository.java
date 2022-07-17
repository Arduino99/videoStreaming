package com.example.replyglue.repository;

import com.example.replyglue.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findUsersByCardNumber(String cardNumber);

    User findUsersByUsername(String username);

    boolean existsUserByUsername(String username);

    boolean existsUserByCardNumber(String cardnumber);
}
