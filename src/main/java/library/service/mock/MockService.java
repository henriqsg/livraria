package library.service.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import library.domain.Book;
import library.domain.Comment;
import library.domain.Costumer;

@Service
public class MockService {
	
	private List<Book> books = buildMockedBooks();
	
	public Comment postBookComment(Long id, String text) {
		Costumer costumer = getCurrentUser();
    	Book book = findBook(id);
    	
    	return new Comment(text, book, costumer);
	}
	
	public List<Book> findBookByCriteria(Long id, String title, String author, Integer pages) {
		 
		
		return books.stream().filter(book -> {
			
			 return book.getId().equals(id) || 
					book.getTitle().equals(title) ||
					book.getAuthor().equals(author) ||
					book.getPages().equals(pages);
			
		 }).collect(Collectors.toList());
	}
	
	private List<Book> buildMockedBooks() {
		List<Book> books = new ArrayList<>();
		
		books.add(new Book(1l, "The first Book", "Author First Book", 100));
		books.add(new Book(2l, "The second Book", "Author Second Book", 200));
		books.add(new Book(3l, "The third Book", "Author Third Book", 300));
		
		return books;
	}
 	
	private Book findBook(Long id) {
		Optional<Book> opt = books.stream().filter(book -> book.getId().equals(id)).findFirst();
		
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}
	
	private Costumer getCurrentUser() {
		return new Costumer();
	}
	
}
