package projekti.bookstore.web;

import org.springframework.web.bind.annotation.RestController;

import projekti.bookstore.model.Book;
import projekti.bookstore.model.BookRepository;
import projekti.bookstore.model.CategoryRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
public class RestBookController {

        @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository crepository;


    @GetMapping("/books")
    public Iterable <Book> getBooks() {
        return repository.findAll();
    }

    @GetMapping("/book/{id}")
    public Optional<Book> getOneBook(@PathVariable("id") Long id){
        return repository.findById(id);
    }
    
    @PostMapping("/book")
    Book newBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }
    
    @PutMapping("/book/{id}")
    Book editBook(@RequestBody Book editBook, @PathVariable Long id) {
        editBook.setId(id);
        return repository.save(editBook);
    }
    

}
