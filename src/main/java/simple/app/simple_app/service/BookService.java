package simple.app.simple_app.service;

import org.springframework.stereotype.Service;
import simple.app.simple_app.mappers.BookMapper;
import simple.app.simple_app.models.Book;
import simple.app.simple_app.models.dto.BookDTO;
import simple.app.simple_app.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private BookMapper bookMapper;
    private BookRepository bookRepository;

    public BookService(BookMapper bookMapper, BookRepository bookRepository) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }

    public BookDTO convertDAOtoDTO (Book book){
        return BookDTO.builder()
                .name(book.getName())
                .kind(book.getKind())
                .yearOfPublication(book.getYearOfPublication())
                .build();
    }


    public void addBook(BookDTO bookDTO){
        bookRepository.save(Book.builder()
        .name(bookDTO.getName())
        .kind(bookDTO.getKind())
        .yearOfPublication(bookDTO.getYearOfPublication())
        .build());
    }

    public List<BookDTO> getAllBooks(){
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book: bookRepository.findAll()) {
            bookDTOList.add(convertDAOtoDTO(book));
        }
        return bookDTOList;
    }

}
