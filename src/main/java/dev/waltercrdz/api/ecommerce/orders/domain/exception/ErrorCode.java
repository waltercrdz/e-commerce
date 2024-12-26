package dev.waltercrdz.api.ecommerce.orders.domain.exception;

public enum ErrorCode {
    DATABASE_CONNECTION_ERROR("DATABASE_CONNECTION_ERROR"),
    ILLEGAL_ARGUMENT("ILLEGAL_ARGUMENT"),
    MISSING_PARAMETER("MISSING_PARAMETER"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR");

    private final String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
