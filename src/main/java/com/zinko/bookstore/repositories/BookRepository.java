package com.zinko.bookstore.repositories;

import com.zinko.bookstore.models.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    List<Book> findByNameLike(String name);

    Book findById(int id);

    Book findByAuthor(int authorId);

    Book findByCategory(int categoryId);

    boolean existsById(int id);
}
