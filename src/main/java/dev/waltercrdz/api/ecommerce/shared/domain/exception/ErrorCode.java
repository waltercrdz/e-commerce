package dev.waltercrdz.api.ecommerce.shared.domain.exception;

public enum ErrorCode {
    DATABASE_CONNECTION_ERROR("DATABASE_CONNECTION_ERROR"),
    PRODUCT_NOT_FOUND("PRODUCT_NOT_FOUND"),
    NOT_ENOUGH_STOCK("NOT_ENOUGH_STOCK"),
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
