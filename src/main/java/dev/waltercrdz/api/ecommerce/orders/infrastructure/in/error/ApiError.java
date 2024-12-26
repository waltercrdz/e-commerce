package dev.waltercrdz.api.ecommerce.orders.infrastructure.in.error;

import dev.waltercrdz.api.ecommerce.orders.domain.exception.DomainException;
import dev.waltercrdz.api.ecommerce.orders.domain.exception.ErrorCode;

import java.util.Objects;

import static com.google.common.base.Preconditions.*;

public record ApiError(String error, String message) {
    public ApiError {
        checkArgument(Objects.nonNull(error), "Code cannot be null");
        checkArgument(Objects.nonNull(message), "Message cannot be null");
    }

    public static ApiError fromDomainException(DomainException e) {
        return new ApiError(e.getCode().getCode(), e.getMessage());
    }

    public static ApiError fromException(ErrorCode errorCode, Exception e) {
        return new ApiError(errorCode.getCode(), e.getMessage());
    }

    public static ApiError fromException(Exception e) {
        return new ApiError(ErrorCode.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }
}
