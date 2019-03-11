package simple.app.simple_app.mappers;

import org.springframework.stereotype.Component;
import simple.app.simple_app.commons.Mapper;
import simple.app.simple_app.models.Book;
import simple.app.simple_app.models.BookWithPicture;
import simple.app.simple_app.models.dto.BookDTO;

@Component
public class BookMapper implements Mapper<BookWithPicture, Book> {

    @Override
    public Book map(BookWithPicture from) {
        return Book.builder()
                .name(from.getName())
                .kind(from.getKind())
                .yearOfPublication(from.getYearOfPublication())
                .nameFile(from.getPicture().getOriginalFilename())
                .price(from.getPrice())
                .build();
    }
}
