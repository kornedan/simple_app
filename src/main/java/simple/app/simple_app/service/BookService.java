package simple.app.simple_app.service;

import org.springframework.stereotype.Service;
import simple.app.simple_app.mappers.BookDTOMapper;
import simple.app.simple_app.mappers.BookMapper;
import simple.app.simple_app.models.Book;
import simple.app.simple_app.models.dto.BookDTO;
import simple.app.simple_app.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookDTOMapper bookDTOMapper;
    private BookMapper bookMapper;
    private BookRepository bookRepository;

    public BookService(BookDTOMapper bookDTOMapper, BookMapper bookMapper, BookRepository bookRepository) {
        this.bookDTOMapper = bookDTOMapper;
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAllBooks() {
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            bookDTOList.add(bookDTOMapper.map(book));
        }
        return bookDTOList;
    }

    public void addBook(BookDTO bookDTO) {
        bookRepository.save(bookMapper.map(bookDTO));
    }

    public void searchBookByNameAndDelete(String name) {
        Optional<Book> book = bookRepository.findBoolByName(name);
        if (book.isPresent()) {
            deleteBook(book.get());
        }
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

}