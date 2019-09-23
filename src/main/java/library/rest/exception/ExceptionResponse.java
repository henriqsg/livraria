package library.rest.exception;

import java.time.LocalDate;

public class ExceptionResponse {

    private String message;
    private Integer status;
    private String timestamp = LocalDate.now().toString();

    ExceptionResponse(String message, Integer statusCode) {
        this.message = message;
        this.status = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }


    public String getTimestamp() {
        return timestamp;
    }

}
