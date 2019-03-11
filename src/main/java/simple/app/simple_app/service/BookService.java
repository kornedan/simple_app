package simple.app.simple_app.service;

import org.springframework.stereotype.Service;
import simple.app.simple_app.local.LocalFileController;
import simple.app.simple_app.local.LocalFileService;
import simple.app.simple_app.mappers.BookDTOMapper;
import simple.app.simple_app.mappers.BookMapper;
import simple.app.simple_app.models.Book;
import simple.app.simple_app.models.BookWithPicture;
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
    private LocalFileService localFileController;

    public BookService(BookDTOMapper bookDTOMapper, BookMapper bookMapper, BookRepository bookRepository, LocalFileService localFileController) {
        this.bookDTOMapper = bookDTOMapper;
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
        this.localFileController = localFileController;
    }

    public List<BookDTO> getAllBooks() {
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            bookDTOList.add(bookDTOMapper.map(book));
        }
        return bookDTOList;
    }

    public void addBook(BookWithPicture bookWithPicture) {
        bookRepository.save(bookMapper.map(bookWithPicture));
    }

    public void searchBookByNameAndDelete(String name) {
        System.out.println(name);
        Optional<Book> book = bookRepository.findBookByName(name);
        if (book.isPresent()) {
            localFileController.deleteFile(book.get().getNameFile());
            deleteBook(book.get());
        }
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

}