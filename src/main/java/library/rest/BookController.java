package library.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import library.domain.Book;
import library.domain.Comment;
import library.service.mock.MockService;

@RestController
@RequestMapping(value="/api")
public class BookController {
	
	@Autowired
	private MockService mockService;
	
	@PostMapping("/book/{id}/comment")
    public Comment bookComment(@RequestParam Long id, String text) {
        return mockService.postBookComment(id, text);
    }
	
    @GetMapping("/book")
    public List<Book> book(Long id, String title, String author, Integer pages) {
        return mockService.findBookByCriteria(id, title, author, pages);
    }
}
