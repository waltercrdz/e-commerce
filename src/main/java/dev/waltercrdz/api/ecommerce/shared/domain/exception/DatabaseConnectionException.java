package dev.waltercrdz.api.ecommerce.shared.domain.exception;

public class DatabaseConnectionException extends DomainException {

        public DatabaseConnectionException(String message, Throwable cause) {
            super(message, ErrorCode.DATABASE_CONNECTION_ERROR, cause);
        }
}
