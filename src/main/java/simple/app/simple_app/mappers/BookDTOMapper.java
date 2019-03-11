package simple.app.simple_app.mappers;

import org.springframework.stereotype.Component;
import simple.app.simple_app.commons.Mapper;
import simple.app.simple_app.models.Book;
import simple.app.simple_app.models.dto.BookDTO;

@Component
public class BookDTOMapper implements Mapper<Book, BookDTO> {

    @Override
    public BookDTO map(Book from) {
        return BookDTO.builder()
                .name(from.getName())
                .kind(from.getKind())
                .yearOfPublication(from.getYearOfPublication())
                .hrefNameFile("http://localhost:8080/api/files/download/" + from.getNameFile())
                .build();
    }
}
