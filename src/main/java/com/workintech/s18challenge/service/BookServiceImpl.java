package com.workintech.s18challenge.service;

import com.workintech.s18challenge.entity.Book;
import com.workintech.s18challenge.entity.Category;
import com.workintech.s18challenge.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    @Override
    public Book findById(long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.orElseThrow(() -> new RuntimeException("Record is not found!"));
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        Book oldBook = findById(book.getId());

       if(book.getCategory() != null)
        oldBook.setCategory(book.getCategory());

       if(book.getName() != null)
           oldBook.setName(book.getName());
       return bookRepository.save(oldBook);

    }
}
