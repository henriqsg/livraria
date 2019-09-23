package library.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import library.domain.*;
import library.rest.exception.BookHasIdentity;
import library.rest.exception.BookNotFound;
import library.rest.exception.CheckoutNotFound;
import library.rest.exception.ShoppingCartNotFound;
import org.springframework.stereotype.Service;

@Service
public class MockService {
	
	private List<Book> books = Book.buildBooks();
	
	public Comment postBookComment(Long id, String text) throws BookNotFound {
		Costumer costumer = getCurrentUser();
    	Book book = findBook(id);

    	if (book == null) {
    		throw new BookNotFound();
		}
    	return new Comment(text, book, costumer);
	}
	
	public List<Book> findBookByCriteria(Long id, String title, String author, Integer pages) {
		if (id == null && title == null && author == null && pages == null) return books;

		return books.stream().filter(book ->
				book.getId().equals(id) ||
						book.getTitle().contains(title == null ? "" : title) ||
						book.getAuthor().contains(title == null ? "" : title) ||
						book.getPages().equals(pages)).collect(Collectors.toList());

	}
	
	private Book findBook(Long id) {
		Optional<Book> opt = books.stream().filter(book -> book.getId().equals(id)).findFirst();

		return opt.orElse(null);
	}
	
	private Costumer getCurrentUser() {
		return new Costumer();
	}

	public ShoppingCart getCurrentUserCart() {
		return new ShoppingCart(getCurrentUser());
	}

	public ShoppingCart addBook(Long shopId, Long bookId) throws ShoppingCartNotFound, BookNotFound {
		if (ShoppingCart.buildShopCart().stream().noneMatch(item-> item.getId().equals(shopId))) {
			throw new ShoppingCartNotFound(400);
		}
		Optional<Book> book = Book.buildBooks().stream().filter(item -> item.getId().equals(bookId)).findFirst();
		if (!book.isPresent()) {
			throw new BookNotFound();
		}
		return new ShoppingCart(shopId, getCurrentUser(), book.get());
	}

	public ShoppingCart removeBook(Long shopId, Long bookId) throws ShoppingCartNotFound, BookNotFound {
		if (ShoppingCart.buildShopCart().stream().noneMatch(item-> item.getId().equals(shopId))) {
			throw new ShoppingCartNotFound(400);
		}
		Optional<Book> book = Book.buildBooks().stream().filter(item -> item.getId().equals(bookId)).findFirst();
		if (!book.isPresent()) {
			throw new BookNotFound();
		}

		return new ShoppingCart(shopId, getCurrentUser());
	}

	public CheckOut checkOut(CheckOut checkout) {
		return checkout;
	}

	public String checkOutStatus(Long orderNumber) throws CheckoutNotFound {
		Optional<CheckOut> opt = CheckOut.buildCheckOuts().stream().filter(item -> item.getOrderNumber().equals(orderNumber)).findFirst();
		if (!opt.isPresent()) {
			throw new CheckoutNotFound(400);
		}
		return opt.get().getStatus();
	}

	public CheckOut getCheckout(Long orderNumber) throws CheckoutNotFound {
		Optional<CheckOut> opt = CheckOut.buildCheckOuts().stream().filter(item -> item.getOrderNumber().equals(orderNumber)).findFirst();
		if (!opt.isPresent()) {
			throw new CheckoutNotFound(400);
		}
		return opt.get();
	}

	public Book registerBook(Book book) throws BookHasIdentity {
		if (book.getId() != null) {
			throw new BookHasIdentity();
		}
		book.setId(100L);
		return book;
	}
}
