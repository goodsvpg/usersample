package com.example.usersample.user.dao;

import com.example.usersample.user.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);

    @Query(value = "SELECT u FROM User u join fetch u.orders WHERE u.name = :name OR u.email = :email")
    Page<User> findUserByNameOrEmail(String name, String email, Pageable pageable);
}
