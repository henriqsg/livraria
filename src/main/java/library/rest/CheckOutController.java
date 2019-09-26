package library.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import library.domain.CheckOut;
import library.rest.exception.CheckoutNotFound;
import library.service.MockService;
import library.util.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/checkout")
@Api(tags = "Pedido/pagamento", value = "CheckOutController", description="Acompanhamento de pedidos pagamentos")
public class CheckOutController {

    @Autowired
    private MockService mockService;

    @PostMapping
    @ApiOperation(value = "Efetua pedidos/pagamentos")
    public ResponseEntity<CheckOut> checkout(
            @ApiParam(value = "Pedido/pagamento") @RequestBody CheckOut checkout) {
        try {
            return ResponseEntity.ok(mockService.checkOut(checkout));
        } catch (Exception e){
            return ResponseEntity.badRequest().headers(HeaderUtil.createHttpHeader(e.getMessage())).build();
        }
    }

    @GetMapping("/{orderNumber}")
    @ApiOperation(value = "Busca por pedidos/pagamentos")
    public ResponseEntity<CheckOut> getCheckout(
            @ApiParam(value = "N. da ordem do pedido/pagamento") @PathVariable Long orderNumber) {
        try {
            return ResponseEntity.ok(mockService.getCheckout(orderNumber));
        } catch (CheckoutNotFound e) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createHttpHeader(e.getMessage())).build();
        }
    }

    @GetMapping
    @ApiOperation(value = "Busca por todos pedidos/pagamentos")
    public ResponseEntity<Object> getAllCheckout() {
        try {
            return ResponseEntity.ok(mockService.getAllCheckout());
        } catch (Exception e) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createHttpHeader(e.getMessage())).build();
        }
    }

    @GetMapping("/{orderNumber}/status")
    @ApiOperation(value = "Busca por status de pedidos/pagamentos")
    public ResponseEntity<String> checkoutStatus(
            @ApiParam(value = "N. da ordem do pedido/pagamento") @PathVariable Long orderNumber) {
        try {
            return ResponseEntity.ok(mockService.checkOutStatus(orderNumber));
        } catch (CheckoutNotFound e) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createHttpHeader(e.getMessage())).build();
        }
    }
}
