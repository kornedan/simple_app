package simple.app.simple_app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductWithPicture {
    private String name;
    private MultipartFile picture;
    private double price;
    private String description;
}
