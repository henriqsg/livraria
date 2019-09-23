package library.rest.exception;

public class CheckoutNotFound extends Exception {

    private ExceptionResponse response;

    private static final String MESSAGE = "This order number does not exists.";

    public CheckoutNotFound(Integer statusCode) {
        this.response = new ExceptionResponse(MESSAGE, statusCode);
    }
    public ExceptionResponse getResponse() {
        return response;
    }

    public void setResponse(ExceptionResponse response) {
        this.response = response;
    }
}
