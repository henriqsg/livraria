package library.rest;

import java.net.URI;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import library.rest.exception.BookHasIdentity;
import library.rest.exception.BookNotFound;
import library.util.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import library.domain.Book;
import library.domain.Comment;
import library.service.MockService;

import javax.validation.Valid;
import javax.xml.ws.Response;

@RestController
@RequestMapping(value="/api/v1/book")
@Api(tags = "Livro", value = "BookController", description="Cadastro, listagem e adição de comentários a livros")
public class BookController {

	@Autowired
	private MockService mockService;

	@PostMapping("/{id}/comment")
    @ApiOperation(value = "Cadastro de comentários a livros")
    public ResponseEntity<Comment> bookComment(
            @ApiParam(value = "Id do livro à comentar") @PathVariable Long id,
            @ApiParam(value = "Comentário") @RequestBody String text) {
	    try {
            return ResponseEntity.ok(mockService.postBookComment(id, text));
        } catch (BookNotFound e){
	        return ResponseEntity.badRequest().headers(HeaderUtil.createHttpHeader(e.getResponse().getMessage())).build();
        }
    }
	
    @GetMapping
    @ApiOperation(value = "Busca de livros por seu id, título, autor ou numero de páginas")
    public ResponseEntity<List<Book>> book(
            @ApiParam(value = "Id do livro a ser buscado") Long id,
            @ApiParam(value = "Título do livro a ser buscado") String title,
            @ApiParam(value = "Autor do livro a ser buscado") String author,
            @ApiParam(value = "N. de páginas do livro a ser buscado") Integer pages) {
	    try {
            return ResponseEntity.ok(mockService.findBookByCriteria(id, title, author, pages));
        } catch (Exception e) {
	        return ResponseEntity.badRequest().headers(HeaderUtil.createHttpHeader(e.getMessage())).build();
        }
    }

    @PostMapping
    @ApiOperation(value = "Cadastro de livros")
    public ResponseEntity<Book> registerBook(
            @ApiParam(value = "Livro a ser cadastrado") @Valid @RequestBody Book book) {
        try {
            return ResponseEntity.created(URI.create("/api/book")).body(mockService.registerBook(book));
        } catch (BookHasIdentity e){
            return ResponseEntity.badRequest().headers(HeaderUtil.createHttpHeader(e.getResponse().getMessage())).build();
        }
    }
}
