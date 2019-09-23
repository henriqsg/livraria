package library.rest.exception;

public class BookNotFound extends Exception {

    private ExceptionResponse response;

    private static final String MESSAGE = "This book does not exists.";

    public BookNotFound() {
        this.response = new ExceptionResponse(MESSAGE, 400);
    }
    public String getMessage() {
        return MESSAGE;
    }

    public ExceptionResponse getResponse() {
        return response;
    }
}
