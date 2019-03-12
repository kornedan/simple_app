package simple.app.simple_app.controllers;

import org.springframework.web.bind.annotation.*;
import simple.app.simple_app.local.LocalFileService;
import simple.app.simple_app.models.ProductWithPicture;
import simple.app.simple_app.service.ProductService;

import java.io.IOException;

@RestController
@RequestMapping("/product")
public class ProductControllerWithREST {

    private ProductService productService;
    private LocalFileService localFileService;

    public ProductControllerWithREST(ProductService productService, LocalFileService localFileService) {
        this.productService = productService;
        this.localFileService = localFileService;
    }

    @PostMapping("/add")
    public void addBook(@ModelAttribute ProductWithPicture productWithPicture) throws IOException {
        productService.addBook(productWithPicture);
        localFileService.addFile(productWithPicture.getPicture());
    }

    @PostMapping("/delete")
    public void deleteBook(@RequestParam String name) {
        productService.searchBookByNameAndDelete(name);
    }
}
