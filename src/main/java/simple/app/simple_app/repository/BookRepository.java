package simple.app.simple_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simple.app.simple_app.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
