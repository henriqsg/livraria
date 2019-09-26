package library.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import library.domain.ShoppingCart;
import library.rest.exception.BookNotFound;
import library.rest.exception.ShoppingCartNotFound;
import library.service.MockService;
import library.util.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value="/api/v1/shop")
@Api(tags = "Carrinhos de compra", value = "ShoppingCartController", description="Manipulação de carrinho de compras.")
public class ShoppingCartController {

    @Autowired
    private MockService mockService;

    @PostMapping("/{shopId}/book/{bookId}")
    @ApiOperation(value = "Adiciona livro ao carrinho de compras")
    public ResponseEntity<ShoppingCart> addBook(
            @ApiParam(value = "Id do carrinho de compras") @PathVariable Long shopId,
            @ApiParam(value = "Id do livro") @PathVariable Long bookId) {
        try {
            return ResponseEntity.created(URI.create("/api/shop")).body(mockService.addBook(shopId, bookId));
        } catch (ShoppingCartNotFound | BookNotFound e){
            return ResponseEntity.badRequest().headers(HeaderUtil.createHttpHeader(e.getMessage())).build();
        }
    }

    @DeleteMapping("/{shopId}/book/{bookId}")
    @ApiOperation(value = "Remove livro ao carrinho de compras")
    public ResponseEntity<ShoppingCart> removeBook(
            @ApiParam(value = "Id do carrinho de compras") @PathVariable Long shopId,
            @ApiParam(value = "Id do livro") @PathVariable Long bookId) {
        try {
            return ResponseEntity.ok(mockService.removeBook(shopId, bookId));
        } catch (ShoppingCartNotFound | BookNotFound e){
            return ResponseEntity.badRequest().headers(HeaderUtil.createHttpHeader(e.getMessage())).build();
        }
    }

    @GetMapping("/current-user")
    @ApiOperation(value = "Busca pelo carrinho do usuário logado")
    public ResponseEntity<ShoppingCart> getCurrentUserCart() {
        try {
            return ResponseEntity.ok(mockService.getCurrentUserCart());
        } catch (Exception e) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createHttpHeader(e.getMessage())).build();
        }
    }

    @GetMapping
    @ApiOperation(value = "Busca por todos os carrinhos de compras")
    public ResponseEntity<Object> allShoppingCart() {
        try {
            return ResponseEntity.ok(mockService.getAllShoppingCart());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
