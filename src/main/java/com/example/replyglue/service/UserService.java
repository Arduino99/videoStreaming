package com.example.replyglue.service;

import com.example.replyglue.model.User;
import com.example.replyglue.exceptions.UserNotFoundException;
import com.example.replyglue.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public boolean existsUserByUsername(String username){
        return userRepository.existsUserByUsername(username);
    }
    public boolean existsUserByCardNumber(String cardNumber){return userRepository.existsUserByCardNumber(cardNumber);}

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
