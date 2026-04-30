package javadoctor.api.exceptions;

import org.springframework.http.HttpStatus;

public class DuplicateResourceException extends AppException {
    public DuplicateResourceException(String resource, String field) {
        super(resource + " already exists with " + field, HttpStatus.CONFLICT);
    }
}