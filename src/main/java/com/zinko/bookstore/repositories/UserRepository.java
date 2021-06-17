package com.zinko.bookstore.repositories;

import com.zinko.bookstore.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);

    User findByEmail(String email);

    User findById(int id);

    boolean existsByEmail(String email);

    boolean existsById(int id);
}
