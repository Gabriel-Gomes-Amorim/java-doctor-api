package javadoctor.api.exceptions.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private int status;
    private String error;
    private String message;
    private LocalDateTime timestamp;
    private List<FieldErrorResponse> fields;

    @Getter
    @Builder
    public static class FieldErrorResponse {
        private String field;
        private String message;
    }
}