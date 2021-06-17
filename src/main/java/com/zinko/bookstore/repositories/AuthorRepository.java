package com.zinko.bookstore.repositories;

import com.zinko.bookstore.dto.AuthorDto;
import com.zinko.bookstore.models.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    Author findByName(String name);
    Author findById(int id);
    boolean existsById(int id);
}
