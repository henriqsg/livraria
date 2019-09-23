package library.rest;

import library.domain.CheckOut;
import library.rest.exception.CheckoutNotFound;
import library.service.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/checkout")
public class CheckOutController {

    @Autowired
    private MockService mockService;

    @PostMapping
    public ResponseEntity<Object> checkout(@RequestBody CheckOut checkout) {
        try {
            return ResponseEntity.ok(mockService.checkOut(checkout));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{orderNumber}")
    public ResponseEntity<Object> getCheckout(@PathVariable Long orderNumber) {
        try {
            return ResponseEntity.ok(mockService.getCheckout(orderNumber));
        } catch (CheckoutNotFound e) {
            return ResponseEntity.badRequest().body(e.getResponse());
        }
    }

    @GetMapping("/{orderNumber}/status")
    public ResponseEntity<Object> checkoutStatus(@PathVariable Long orderNumber) {
        try {
            return ResponseEntity.ok(mockService.checkOutStatus(orderNumber));
        } catch (CheckoutNotFound e) {
            return ResponseEntity.badRequest().body(e.getResponse());
        }
    }
}
