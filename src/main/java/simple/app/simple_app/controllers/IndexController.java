package simple.app.simple_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import simple.app.simple_app.service.BookService;

@Controller
public class IndexController {

    private BookService bookService;

    public IndexController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/")
    public String indexController(Model model) {
        model.addAttribute("book", bookService.getAllBooks());
        return "index";
    }

}
