package com.example.pgcrud.controller;


import com.example.pgcrud.dto.BookDto;
import com.example.pgcrud.model.Book;
import com.example.pgcrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/insert")
    public ResponseEntity<Book> createBook(@RequestBody BookDto bookDto){
        Book book=bookService.insertBook(bookDto);

        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<BookDto> findById(@PathVariable Long id){
        BookDto bookDto=bookService.findBookById(id);
        return new ResponseEntity<>(bookDto,HttpStatus.OK);
    }
}
