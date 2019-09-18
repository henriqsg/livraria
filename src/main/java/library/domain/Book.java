package library.domain;

public class Book {
	
	private Long id;
	private String title;
	private String author;
	private Integer pages;
	
	public Book(Long id, String title, String author, Integer pages) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.pages = pages;
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
	
}
