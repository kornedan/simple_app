package simple.app.simple_app.mappers;

import org.springframework.stereotype.Component;
import simple.app.simple_app.commons.Mapper;
import simple.app.simple_app.models.Product;
import simple.app.simple_app.models.dto.ProductDTO;

@Component
public class ProductDTOMapper implements Mapper<Product, ProductDTO> {

    @Override
    public ProductDTO map(Product from) {
        return ProductDTO.builder()
                .name(from.getName())
                .price(from.getPrice())
                .description(from.getDescription())
                .hrefNameFile("http://localhost:8080/api/files/download/" + from.getNameFile())
                .build();
    }
}
