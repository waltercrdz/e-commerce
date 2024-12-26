package dev.waltercrdz.api.ecommerce.orders.domain.exception;

public class DomainException extends RuntimeException {

    private final ErrorCode code;

    public DomainException(String message, ErrorCode code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public ErrorCode getCode() {
        return code;
    }
}
