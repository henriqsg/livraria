package library.rest.exception;

public class ShoppingCartNotFound extends Exception {

    private static final String MESSAGE = "This shopping cart does not exists.";

    private ExceptionResponse response;

    public ShoppingCartNotFound(Integer statusCode) {
        this.response = new ExceptionResponse(MESSAGE, statusCode);
    }

    public ExceptionResponse getResponse() {
        return response;
    }
}
