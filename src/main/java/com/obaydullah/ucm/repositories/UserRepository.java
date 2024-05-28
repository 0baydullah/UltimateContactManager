package com.obaydullah.ucm.repositories;

import com.obaydullah.ucm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /// ************ extra methods for db operations ***************

    /// custom finder method

    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);


    ///  custom query method
}
