package com.stackroute.Soulmaterestservice.service;

import com.stackroute.Soulmaterestservice.exception.RecordNotFoundException;
import com.stackroute.Soulmaterestservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User AddorUpdateUser(User user);
    List<User> getAllUsers();
    User searchByAgeAndGender(int age,String gender);
    Optional<User> getUserById(int id) throws RecordNotFoundException;
    List<User> searchUserByName(String name);

}
