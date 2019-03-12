package simple.app.simple_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import simple.app.simple_app.models.dto.ProductDTO;
import simple.app.simple_app.service.ProductService;

@Controller
public class IndexController {

    private ProductService productService;

    public IndexController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/")
    public String indexController(Model model) {
        model.addAttribute("product", productService.getAllProducts());
        return "index";
    }

    @PostMapping("/detailProduct")
    public String deatailBookController (@ModelAttribute ProductDTO productDTO, Model model){
        model.addAttribute("product", productDTO);
        return "detailProduct";
    }

    @RequestMapping("/buyProduct")
    public String buyProductController(){
        return "buyProduct";
    }

}
