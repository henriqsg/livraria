package library.util;

import org.springframework.http.HttpHeaders;

public class HeaderUtil {

    private static final String ERROR_HEADER_KEY = "Xx-error-message";

    public static HttpHeaders  createHttpHeader(String content) {
        HttpHeaders header = new HttpHeaders();
        header.set(ERROR_HEADER_KEY, content);

        return header;
    }
}
