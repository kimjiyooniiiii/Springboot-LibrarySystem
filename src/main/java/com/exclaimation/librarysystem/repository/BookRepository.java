package com.exclaimation.librarysystem.repository;

import com.exclaimation.librarysystem.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b where b.title like concat('%' , :title , '%') or b.content like concat('%', :content, '%')")
    Page<Book> findByKeyword(String title, String content, Pageable page);
}
