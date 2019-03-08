package simple.app.simple_app.mappers;

import org.springframework.stereotype.Component;
import simple.app.simple_app.commons.Mapper;
import simple.app.simple_app.models.Book;
import simple.app.simple_app.models.dto.BookDTO;

@Component
public class BookMapper implements Mapper<BookDTO, Book> {

    @Override
    public Book map(BookDTO from) {
        return Book.builder()
                .name(from.getName())
                .kind(from.getKind())
                .yearOfPublication(from.getYearOfPublication())
                .build();
    }
}
