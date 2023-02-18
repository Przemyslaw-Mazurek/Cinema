package com.example.Cinema.user;

import com.example.Cinema.exceptions.EmailAlreadyExistsException;
import com.example.Cinema.model.User;
import com.example.Cinema.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.text.MessageFormat;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user1;
    private User user2;
    private User user3;
    private User user4;
    private User user5;

    @BeforeEach
    public void initializeUsersAndSaveThemToDB() {
        userRepository.deleteAll();

        user1 = new User(1L, "Jan", "Kowal",
                "jan.kowal@gmail.com", 123456789, false, null, null);
        user2 = new User(2L, "Ania", "Byk",
                "ania.byk@gmail.com", 234561256, true, null, null);
        user3 = new User(3L, "Marcin", "Zupa",
                "marcin.zupa@gmail.com", 987654321, false, null, null);
        user4 = new User(4L, "Jan", "Kowal",
                "jan.kowal@o2.com", 345345345, false, null, null);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
    }

    @Test
    public void verifyItReturnsListWithSpecificNameAndSurname() {
        //when
        List<User> listByFirstNameAndLastName = userRepository.findByFirstNameAndLastNameEqualsIgnoreCase("Jan", "Kowal");
        User firstUser = listByFirstNameAndLastName.get(0);
        User secondUser = listByFirstNameAndLastName.get(1);
        //then
        assertEquals(firstUser.getFirstName(), secondUser.getFirstName());
        assertEquals(secondUser.getLastName(), secondUser.getLastName());
    }

    @Test
    public void verifyItFoundUserWithSpecificEmail(){
        //given
        String exampleEmail = "ania.byk@gmail.com";
        //when
        User userFoundByEmail = userRepository.findByEmail(exampleEmail);
        //then
        assertEquals(exampleEmail, userFoundByEmail.getEmail());
        assertEquals(2, userFoundByEmail.getId());
    }


}
