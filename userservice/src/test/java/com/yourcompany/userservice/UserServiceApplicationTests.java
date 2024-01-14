package com.yourcompany.userservice;

import com.yourcompany.userservice.model.User;
import com.yourcompany.userservice.repository.UserRepository;
import com.yourcompany.userservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceApplicationTests {

    @Test
    void contextLoads() {

    }
    @ExtendWith(MockitoExtension.class)


        @Mock
        private UserRepository userRepository;

        @InjectMocks
        private UserService userService;

        @Test
        public void whenGetUsersByFirstName_thenReturnUserList() {
            // Arrange
            String firstName = "John";
            User user1 = new User();
            User user2 = new User();
            List<User> expectedUsers = new ArrayList<>();
            expectedUsers.add(user1);
            expectedUsers.add(user2);

            when(userRepository.findByFirstName(firstName)).thenReturn(expectedUsers);

            // Act
            List<User> actualUsers = userService.getUsersByFirstName(firstName);

            // Assert
            assertEquals(expectedUsers, actualUsers, "Should return a list of users with the same first name");
        }
    }



