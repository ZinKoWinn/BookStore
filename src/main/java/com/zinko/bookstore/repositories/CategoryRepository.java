package com.zinko.bookstore.repositories;

import com.zinko.bookstore.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String name);

    @Query("update Category set name = :name where id = :id")
    Category update(@Param("name") String name, @Param("id") int id);

    Category findById(int id);

    boolean existsById(int id);

}
