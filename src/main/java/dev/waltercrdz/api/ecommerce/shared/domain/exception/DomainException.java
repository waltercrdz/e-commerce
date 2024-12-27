package dev.waltercrdz.api.ecommerce.shared.domain.exception;

import java.util.Map;

public class DomainException extends RuntimeException {

    private final ErrorCode code;
    private final Map<String, Object> metadata;

    public DomainException(String message, ErrorCode code) {
        super(message);
        this.code = code;
        this.metadata = null;
    }
    
    public DomainException(String message, ErrorCode code, Map<String, Object> metadata) {
        super(message);
        this.code = code;
        this.metadata = metadata;
    }
    
    public DomainException(String message, ErrorCode code, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.metadata = null;
    }

    public ErrorCode getCode() {
        return code;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }
}
