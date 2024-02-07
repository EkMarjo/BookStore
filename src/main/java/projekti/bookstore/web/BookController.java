package projekti.bookstore.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import projekti.bookstore.model.Book;
import projekti.bookstore.model.BookRepository;
import projekti.bookstore.model.CategoryRepository;

import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class BookController {
   
    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository crepository;

    @RequestMapping(value= {"/", "/booklist"})
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    @RequestMapping(value = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categorys", crepository.findAll());
        return "addbook";
    }
    @RequestMapping(value= "/save", method=RequestMethod.POST)
    public String save(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        repository.deleteById(id);
        return "redirect:../booklist";
    }
    @RequestMapping(value="/editBook/{id}", method=RequestMethod.GET)
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("editBook", repository.findById(id));
        model.addAttribute("categorys", crepository.findAll());
        return "editBook";
    }
    
    
    
    

}




