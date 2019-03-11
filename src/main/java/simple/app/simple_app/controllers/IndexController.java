package simple.app.simple_app.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import simple.app.simple_app.models.dto.BookDTO;
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


    @RequestMapping("/admin")
    public String adminController(){
        return "admin";
    }


    @PostMapping("/detailBook")
    public String deatailBook (@ModelAttribute BookDTO bookDTO, Model model){
        model.addAttribute("product", bookDTO);
        return "detailProduct";
    }
}
