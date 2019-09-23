package library.rest;

import library.rest.exception.BookNotFound;
import library.rest.exception.ShoppingCartNotFound;
import library.service.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/shop")
public class ShoppingCartController {

    @Autowired
    private MockService mockService;

    @PostMapping("/{shopId}/book/{bookId}")
    public ResponseEntity<Object> addBook(@PathVariable Long shopId, @PathVariable Long bookId) {
        try {
            return ResponseEntity.ok(mockService.addBook(shopId, bookId));
        } catch (ShoppingCartNotFound e){
            return ResponseEntity.badRequest().body(e.getResponse());
        } catch (BookNotFound e) {
            return ResponseEntity.badRequest().body(e.getResponse());
        }
    }

    @DeleteMapping("/{shopId}/book/{bookId}")
    public ResponseEntity<Object> removeBook(@PathVariable Long shopId, @PathVariable Long bookId) {
        try {
            return ResponseEntity.ok(mockService.removeBook(shopId, bookId));
        } catch (ShoppingCartNotFound e){
            return ResponseEntity.badRequest().body(e.getResponse());
        } catch (BookNotFound e) {
            return ResponseEntity.badRequest().body(e.getResponse());
        }
    }

    @GetMapping("/current-user")
    public ResponseEntity<Object> getCurrentUserCart() {
        try {
            return ResponseEntity.ok(mockService.getCurrentUserCart());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
