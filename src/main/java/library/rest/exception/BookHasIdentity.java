package library.rest.exception;

public class BookHasIdentity extends Exception {

    private ExceptionResponse response;

    private static final String MESSAGE = "You cannot save a book with an id.";

    public BookHasIdentity() {
        this.response = new ExceptionResponse(MESSAGE, 400);
    }
    public String getMessage() {
        return MESSAGE;
    }

    public ExceptionResponse getResponse() {
        return response;
    }
}
