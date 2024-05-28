package com.obaydullah.ucm.services;

import com.obaydullah.ucm.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    Optional<User> getUserById(String id);

    Optional<User>  updateUser(User user);

    void deleteUser(String id);

    List<User> getAllUsers();

    boolean isUserExist(String userId);

    boolean isUserExistByEmail(String email);
}
