package projekti.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

import projekti.bookstore.model.Book;
import projekti.bookstore.model.BookRepository;
import projekti.bookstore.model.Category;
import projekti.bookstore.model.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args){
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository){
		return (args) -> {
			log.info("tallenna kirjoja");

			Category c1 = new Category("Fantasy");
			Category c2 = new Category("Detective");
			Category c3 = new Category("Thriller");
			Category c4 = new Category("Romance");
			
			crepository.save(c1);
			crepository.save(c2);
			crepository.save(c3);
			crepository.save(c4);

			repository.save(new Book("Kirja1", "Kirjailija1", "isbn1", 2020, 19.95, c1));
			repository.save(new Book("Kirja2", "Kirjailija2", "isbn2", 2012, 10.15, c2));


			log.info("Näytä kaikki kirjat");
			for(Book book : repository.findAll()){
				log.info(book.toString());
			}
			
		};
	}
	


    
}
