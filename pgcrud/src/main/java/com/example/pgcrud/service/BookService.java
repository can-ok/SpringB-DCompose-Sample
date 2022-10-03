package com.example.pgcrud.service;


import com.example.pgcrud.dto.BookDto;
import com.example.pgcrud.model.Book;
import com.example.pgcrud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDto findBookById(Long id){
        Optional<Book> bookOpt=bookRepository.findById(id);
        if(bookOpt.isEmpty()){
            return new BookDto();
        }
        else {
            Book book=bookOpt.get();
            return new BookDto(book.getTitle(),book.getIsbn(), book.getAuthor());
        }
    }
    public Book insertBook(BookDto bookDto){
        Book book=new Book();
        book.setIsbn(bookDto.getIsbn());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        return bookRepository.save(book);
    }
}
