package projekti.bookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import projekti.bookstore.model.AppUser;
import projekti.bookstore.model.AppUserRepository;
import projekti.bookstore.model.Book;
import projekti.bookstore.model.BookRepository;
import projekti.bookstore.model.CategoryRepository;
import projekti.bookstore.model.Category;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JpaTest {

    @Autowired
    private BookRepository brepository;

    @Autowired
    private CategoryRepository crepository;

   

   
    @Test
    public void searchByTitle(){
        List<Book> books = brepository.findByTitle("Kirja1");
        assertThat(books).hasSize(1);
    }

    @Test
    public void createNewBook(){
        Category category = new Category("Horror");
        crepository.save(category);
        Book book = new Book("Kirja3", "Kirjailija3", "ISBN3", 1995, 15.50, category);
        brepository.save(book);
        assertThat(book.getId()).isNotNull();

    }

    @Test
    public void deleteNewBook (){
        List<Book> books = brepository.findByTitle("Kirja1");
        Book book = books.get(0);
        brepository.delete(book);
        List<Book> newBooks = brepository.findByTitle("Kirja1");
        assertThat(newBooks).hasSize(0);

    }
    

}
