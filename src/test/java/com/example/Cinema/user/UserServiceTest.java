package com.example.Cinema.user;

import com.example.Cinema.exceptions.EmailAlreadyExistsException;
import com.example.Cinema.exceptions.NoSuchElementFoundException;
import com.example.Cinema.model.Address;
import com.example.Cinema.model.User;
import com.example.Cinema.repositories.UserRepository;
import com.example.Cinema.services.AddressService;
import com.example.Cinema.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;
    private UserService userService;

    public void beforeEach() {
        userService = new UserService(userRepository);
    }


}

