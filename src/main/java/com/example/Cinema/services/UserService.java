package com.example.Cinema.services;

import com.example.Cinema.exceptions.NoSuchElementFoundException;
import com.example.Cinema.model.User;
import com.example.Cinema.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final String userNotFound = "User with id = {0} not found.";
    private final String userByNameAndSurnameNotFound = "Users with name and surname {0} {1} not found.";
    private final String userByEmailNotFound = "User with email {0} not found.";


    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(userNotFound, id)));

        return user;
    }

    public List <User> getUsersByFirstNameAndLastName(String firstName, String lastName){
       List<User> users = userRepository.findByFirstNameAndLastName(firstName, lastName);
       if (users.isEmpty()){
           throw new NoSuchElementFoundException(MessageFormat.format(userByNameAndSurnameNotFound, firstName, lastName));
       }

       return users;
    }

    public User getUserByEmail(String email){
        User user = userRepository.findByEmail(email);

        if (user==null){
            throw new NoSuchElementFoundException(MessageFormat.format(userByEmailNotFound, email));
        }

        return user;
    }

    public User updateUser(Long id, User user) {
        User userFromDB = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(userNotFound, id)));

        userRepository.save(user);

        return user;
    }

    public void removeUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(userNotFound, id)));
        userRepository.deleteById(id);
    }
}
