package library.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Comment {

	@JsonIgnore
	private Costumer author;

	private String text;
	private Book book;
	
	public Comment(String text, Book book, Costumer author) {
		this.text = text;
		this.book = book;
		this.author = author;
	}


	public void setText(String text) {
		this.text = text;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Costumer getAuthor() {
		return author;
	}

	public void setAuthor(Costumer author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}
	
}
