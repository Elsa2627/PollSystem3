package com.yourcompany.userservice.repository;

import com.yourcompany.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    List<User> findByAge(int age);

    List<User> findByAgeBetween(int startAge, int endAge);

    List<User> findByAddress(String address);

    List<User> findByJoiningDate(Date joiningDate);

}
