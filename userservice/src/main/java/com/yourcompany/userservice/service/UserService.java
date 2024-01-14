package com.yourcompany.userservice.service;

import com.yourcompany.userservice.dto.UserDto;
import com.yourcompany.userservice.model.User;
import com.yourcompany.userservice.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final RestTemplate restTemplate;
    private final UserRepository userRepository;

    @Getter
    private String email;


    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setAge(userDto.getAge());
        user.setAddress(userDto.getAddress());

        return userRepository.save(user);
    }

    public Optional<User> updateUser(Long id, User userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(userDetails.getFirstName());
                    user.setLastName(userDetails.getLastName());
                    user.setEmail(userDetails.getEmail());
                    user.setAge(userDetails.getAge());
                    user.setAddress(userDetails.getAddress());
                    user.setJoiningDate(userDetails.getJoiningDate());
                    return userRepository.save(user);
                });
    }


    public List<User> getUsersByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public List<User> getUsersByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public List<User> getUsersByAge(int age) {
        return userRepository.findByAge(age);
    }

    public List<User> getUsersByAgeRange(int startAge, int endAge) {
        return userRepository.findByAgeBetween(startAge, endAge);
    }

    public List<User> getUsersByAddress(String address) {
        return userRepository.findByAddress(address);
    }

    public List<User> getUsersByJoiningDate(Date joiningDate) {
        return userRepository.findByJoiningDate(joiningDate);
    }

    public void deleteUser(Long id) {
    }
}
