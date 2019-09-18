package library.domain;

public class Costumer {
	
	private Long id;
	private String name;
	private String email;
	
	public Costumer() {
		this.id = 1L;
		this.name = "The lonely costumer";
		this.email = "lonely@library.com";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}