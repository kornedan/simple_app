package simple.app.simple_app.service;

import org.springframework.stereotype.Service;
import simple.app.simple_app.local.LocalFileService;
import simple.app.simple_app.mappers.ProductDTOMapper;
import simple.app.simple_app.mappers.ProductMapper;
import simple.app.simple_app.models.Product;
import simple.app.simple_app.models.ProductWithPicture;
import simple.app.simple_app.models.dto.ProductDTO;
import simple.app.simple_app.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductDTOMapper productDTOMapper;
    private ProductMapper productMapper;
    private ProductRepository productRepository;
    private LocalFileService localFileController;

    public ProductService(ProductDTOMapper productDTOMapper, ProductMapper productMapper, ProductRepository productRepository, LocalFileService localFileController) {
        this.productDTOMapper = productDTOMapper;
        this.productMapper = productMapper;
        this.productRepository = productRepository;
        this.localFileController = localFileController;
    }

    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            productDTOList.add(productDTOMapper.map(product));
        }
        return productDTOList;
    }

    public void addBook(ProductWithPicture productWithPicture) {
        productRepository.save(productMapper.map(productWithPicture));
    }

    public void searchBookByNameAndDelete(String name) {
        System.out.println(name);
        Optional<Product> book = productRepository.findBookByName(name);
        if (book.isPresent()) {
            localFileController.deleteFile(book.get().getNameFile());
            deleteBook(book.get());
        }
    }

    public void deleteBook(Product product) {
        productRepository.delete(product);
    }

}