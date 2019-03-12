package simple.app.simple_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import simple.app.simple_app.local.LocalFileService;
import simple.app.simple_app.models.ProductWithPicture;
import simple.app.simple_app.service.ProductService;

import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping
    public String adminController(){
        return "admin";
    }

    private ProductService productService;
    private LocalFileService localFileService;

    public AdminController(ProductService productService, LocalFileService localFileService) {
        this.productService = productService;
        this.localFileService = localFileService;
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute ProductWithPicture productWithPicture) throws IOException {
        productService.addBook(productWithPicture);
        localFileService.addFile(productWithPicture.getPicture());
        return "redirect:/admin";
    }


    @PostMapping("/delete")
    public String deleteBook(@RequestParam String name) {
        productService.searchBookByNameAndDelete(name);
        return "redirect:/admin";
    }
}
