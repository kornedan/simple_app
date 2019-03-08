package simple.app.simple_app.commons;

import simple.app.simple_app.models.Book;
import simple.app.simple_app.models.dto.BookDTO;

public interface Mapper<F, T> {
    T map(F from);

}
