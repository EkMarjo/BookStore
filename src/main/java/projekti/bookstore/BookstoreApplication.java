package projekti.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import projekti.bookstore.model.Book;
import projekti.bookstore.model.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args){
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository){
		return (args) -> {
			log.info("tallenna kirjoja");
			repository.save(new Book("Kirja1", "Kirjailia1", "isbn1", 2010, 19.90));
			repository.save(new Book("Kirja2", "Kirjalija2", "isbn2", 2022, 29.99));

			log.info("Näytä kaikki kirjat");
			for(Book book : repository.findAll()){
				log.info(book.toString());
			}
			
		};
	}
	


    
}
