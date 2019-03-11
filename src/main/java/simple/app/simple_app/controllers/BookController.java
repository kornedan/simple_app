package simple.app.simple_app.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import simple.app.simple_app.local.LocalFileService;
import simple.app.simple_app.models.BookWithPicture;
import simple.app.simple_app.models.dto.BookDTO;
import simple.app.simple_app.service.BookService;

import java.io.IOException;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;
    private LocalFileService localFileService;

    public BookController(BookService bookService, LocalFileService localFileService) {
        this.bookService = bookService;
        this.localFileService = localFileService;
    }

    @PostMapping("/addbook")
    public String addBook(@ModelAttribute BookWithPicture bookWithPicture) throws IOException {
        bookService.addBook(bookWithPicture);

        localFileService.addFile(bookWithPicture.getPicture());
        return "admin";
    }


    @PostMapping("/delete")
    public void deleteBook(@RequestParam String name) {
        bookService.searchBookByNameAndDelete(name);
    }


}
