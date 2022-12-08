package com.example.libraryappnewbackend.dao;

import com.example.libraryappnewbackend.model.Books;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BooksDao extends CrudRepository<Books, Integer> {

    @Query(value = "SELECT `id`, `author`, `book_name`, `description`, `distributor`, `image`, `language`, `released_year` FROM `books` WHERE `book_name`LIKE %:bookName%",nativeQuery = true)
    List<Books> SearchBooks(@Param("bookName") String bookName);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM `books` WHERE `id`=:id",nativeQuery = true)
    void DeleteBook(@Param("id") Integer id);

}
