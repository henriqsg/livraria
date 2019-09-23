package library.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private Long id;
    private Costumer owner;
    private List<Book> bookList = new ArrayList<>();
    @JsonIgnore
    private CheckOut checkOut;

    public ShoppingCart(Costumer costumer) {
        this.id = 1L;
        this.owner = costumer;
        bookList.addAll(Book.buildBooks());
        this.checkOut = new CheckOut();
    }

    public ShoppingCart(Long id, Costumer costumer, CheckOut checkOut) {
        this.id = id;
        this.owner = costumer;
        bookList.addAll(Book.buildBooks());
        this.checkOut = checkOut;
    }

    public ShoppingCart(Long id, Costumer costumer, Book book) {
        this.id = id;
        this.owner = costumer;
        this.bookList.add(book);
    }

    public ShoppingCart(Long id, Costumer costumer) {
        this.id = id;
        this.owner = costumer;
        this.bookList.clear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Costumer getOwner() {
        return owner;
    }

    public void setOwner(Costumer owner) {
        this.owner = owner;
    }

    public CheckOut getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(CheckOut checkOut) {
        this.checkOut = checkOut;
    }

    public static List<ShoppingCart> buildShopCart() {
        List<ShoppingCart> list = new ArrayList<>();

        list.add(new ShoppingCart(1L, new Costumer(), new CheckOut()));
        list.add(new ShoppingCart(2L, new Costumer(), new CheckOut()));
        return list;
    }
}
