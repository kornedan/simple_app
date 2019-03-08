package simple.app.simple_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import simple.app.simple_app.models.dto.BookDTO;
import simple.app.simple_app.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping("/addbook")
    public void addBook(@RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);
    }


    @DeleteMapping("/delete/{name}")
    public void deleteBook(@PathVariable String name) {
        bookService.searchBookByNameAndDelete(name);
    }


}
