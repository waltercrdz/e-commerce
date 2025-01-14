package dev.waltercrdz.api.ecommerce.orders.infrastructure.in.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import dev.waltercrdz.api.ecommerce.shared.domain.exception.DatabaseConnectionException;
import dev.waltercrdz.api.ecommerce.shared.domain.exception.ErrorCode;
import dev.waltercrdz.api.ecommerce.shared.domain.exception.NotEnoughStockException;
import dev.waltercrdz.api.ecommerce.shared.domain.exception.ProductNotFoundException;
import dev.waltercrdz.api.ecommerce.shared.infrastructure.in.error.ApiError;

@ControllerAdvice
public class ErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiError handleIllegalArgumentException(IllegalArgumentException e) {
        LOGGER.error("Illegal argument: ", e);
        return ApiError.fromException(ErrorCode.ILLEGAL_ARGUMENT, e);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiError handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        LOGGER.error("Argument Not Valid: ", e);
        return ApiError.fromException(ErrorCode.ILLEGAL_ARGUMENT, e);
    }
    
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiError handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        LOGGER.error("Argument Not Valid: ", e);
        return ApiError.fromException(ErrorCode.ILLEGAL_ARGUMENT, e);
    }

    @ExceptionHandler(DatabaseConnectionException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ResponseBody
    public ApiError handleDatabaseConnectionException(DatabaseConnectionException e) {
        LOGGER.error("Database connection: ", e);
        return ApiError.fromDomainException(e);
    }
    
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiError handleProductNotFoundException(ProductNotFoundException e) {
        LOGGER.error("Product Not Found: ", e);
        return ApiError.fromDomainException(e);
    }
    
    @ExceptionHandler(NotEnoughStockException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ApiError handleNotEnoughStockException(NotEnoughStockException e) {
        LOGGER.error("Insufficient Stock: ", e);
        return ApiError.fromDomainException(e);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiError handleNoHandlerFoundException(NoHandlerFoundException e) {
        return ApiError.fromException(ErrorCode.NOT_FOUND, e);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleUnexpectedException(Exception e) {
        LOGGER.error("Unexpected exception: ", e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiError.fromException(e));
    }
}
