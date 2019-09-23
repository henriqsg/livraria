package library.rest;

import java.util.List;

import library.rest.exception.BookHasIdentity;
import library.rest.exception.BookNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import library.domain.Book;
import library.domain.Comment;
import library.service.MockService;

import javax.validation.Valid;
import javax.xml.ws.Response;

@RestController
@RequestMapping(value="/api/book")
public class BookController {
	
	@Autowired
	private MockService mockService;
	
	@PostMapping("/{id}/comment")
    public ResponseEntity<Object> bookComment(@PathVariable Long id, @RequestBody String text) {
	    try {
            return ResponseEntity.ok(mockService.postBookComment(id, text));
        } catch (BookNotFound e){
	        return ResponseEntity.badRequest().body(e.getResponse());
        }
    }
	
    @GetMapping
    public ResponseEntity<Object> book(Long id, String title, String author, Integer pages) {
	    try {
            return ResponseEntity.ok(mockService.findBookByCriteria(id, title, author, pages));
        } catch (Exception e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> registerBook(@Valid @RequestBody Book book) {
        try {
            return ResponseEntity.ok(mockService.registerBook(book));
        } catch (BookHasIdentity e){
            return ResponseEntity.badRequest().body(e.getResponse());
        }
    }
}
