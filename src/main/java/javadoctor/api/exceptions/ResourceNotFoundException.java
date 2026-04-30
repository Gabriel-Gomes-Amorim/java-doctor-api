package javadoctor.api.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends AppException {
    public ResourceNotFoundException(String resource) {
        super(resource + " not found", HttpStatus.NOT_FOUND);
    }
}