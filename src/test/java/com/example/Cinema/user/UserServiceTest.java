package com.example.Cinema.user;

import com.example.Cinema.exceptions.EmailAlreadyExistsException;
import com.example.Cinema.model.User;
import com.example.Cinema.repositories.UserRepository;
import com.example.Cinema.services.AddressService;
import com.example.Cinema.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.MessageFormat;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService userService;
    private User user1;

    @BeforeEach
    public void setUpUserServiceAndUser(){
        userService = new UserService(userRepository);
        user1 = new User(1L, "Jan", "Kowal",
                "jan.kowal@gmail.com", 123456789, false, null, null);
        userService.addUser(user1);
    }

    @Test
    @Disabled
    public void throwsEmailAlreadyExistsException(){
        //given
       User user2 = new User(2L, "Jan", "Kowalczyk",
                "jan.kowal@gmail.com", 222222222, true, null, null);
        //when
        assertThrows(EmailAlreadyExistsException.class, ()-> userService.addUser(user2));
    }
}
