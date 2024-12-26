package dev.waltercrdz.api.ecommerce.orders.infrastructure.in.error;

import dev.waltercrdz.api.ecommerce.orders.domain.exception.DatabaseConnectionException;
import dev.waltercrdz.api.ecommerce.orders.domain.exception.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArgumentException(IllegalArgumentException e) {
        LOGGER.error("Illegal argument: ", e);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiError.fromException(ErrorCode.ILLEGAL_ARGUMENT, e));
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        LOGGER.error("Argument Not Valid: ", e);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiError.fromException(ErrorCode.ILLEGAL_ARGUMENT, e));
    }

    @ExceptionHandler(DatabaseConnectionException.class)
    public ResponseEntity<ApiError> handleDatabaseConnectionException(DatabaseConnectionException e) {
        LOGGER.error("Database connection: ", e);
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(ApiError.fromDomainException(e));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleUnexpectedException(Exception e) {
        LOGGER.error("Unexpected exception: ", e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiError.fromException(e));
    }
}
