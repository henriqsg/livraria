package library.domain;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Book {
	
	private Long id;
	@NotNull
	private String title;
	@NotNull
	private String author;
	@NotNull
	private Integer pages;
	@NotNull
	private Integer price;
	
	public Book(Long id, String title, String author, Integer pages, Integer price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.price = price;
	}

	public Book (Long id) {
		this.id = id;
		this.title = "First book";
		this.author = "Author of First book";
		this.pages = 100;
		this.price = 25;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static List<Book> buildBooks() {
		List<Book> books = new ArrayList<>();

		books.add(new Book(1L, "The first Book", "Author First Book", 100, 20));
		books.add(new Book(2L, "The second Book", "Author Second Book", 200, 45));
		books.add(new Book(3L, "The third Book", "Author Third Book", 300, 60));
		return books;
	}
}
