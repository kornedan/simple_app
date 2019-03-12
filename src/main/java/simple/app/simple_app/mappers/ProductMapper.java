package simple.app.simple_app.mappers;

import org.springframework.stereotype.Component;
import simple.app.simple_app.commons.Mapper;
import simple.app.simple_app.models.Product;
import simple.app.simple_app.models.ProductWithPicture;

@Component
public class ProductMapper implements Mapper<ProductWithPicture, Product> {

    @Override
    public Product map(ProductWithPicture from) {
        return Product.builder()
                .name(from.getName())
                .kind(from.getKind())
                .yearOfPublication(from.getYearOfPublication())
                .nameFile(from.getPicture().getOriginalFilename())
                .price(from.getPrice())
                .build();
    }
}
