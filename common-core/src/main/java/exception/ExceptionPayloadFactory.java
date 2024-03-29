package exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionPayloadFactory {

    TECHNICAL_ERROR(0, HttpStatus.INTERNAL_SERVER_ERROR, "technical.error"),

    INVALID_PAYLOAD(1, HttpStatus.BAD_REQUEST, "invalid.request.payload"),
    MISSING_REQUEST_BODY_ERROR_CODE(2, HttpStatus.BAD_REQUEST, "request.missing.body"),
    EMAIL_ALREADY_EXIST(3, HttpStatus.BAD_REQUEST, "email.already.exist"),
    USER_NAME_ALREADY_EXIST(3, HttpStatus.BAD_REQUEST, "username.already.exist"),
    USER_NAME_NOT_FOUND(4, HttpStatus.NOT_FOUND, "username.not.found"),
    CUSTOMER_NOT_FOUND(5, HttpStatus.NOT_FOUND, "customer.not.found"),
    DRIVER_NOT_FOUND(6, HttpStatus.NOT_FOUND, "driver.not.found"),
    DRIVER_LOCATION_NOT_FOUND(7, HttpStatus.NOT_FOUND, "driver.location.not.found"),
    CAR_NOT_FOUND(8, HttpStatus.NOT_FOUND, "car.not.found"),
    LOCATION_NOT_FOUND(9, HttpStatus.NOT_FOUND, "location.not.found"),
    RATING_NOT_FOUND(10, HttpStatus.NOT_FOUND, "rating.not.found"),
    ORDER_NOT_FOUND(11, HttpStatus.NOT_FOUND, "order.not.found"),
    BANK_ACCOUNT_NOT_FOUND(12, HttpStatus.NOT_FOUND, "bank.account.not.found"),
    WALLET_NOT_FOUND(13, HttpStatus.NOT_FOUND, "wallet.not.found"),
    CREDIT_CARD_NOT_FOUND(14, HttpStatus.NOT_FOUND, "credit.crad.not.found"),
    WALLER_FOR_ACCOUNT_NOT_FOUND(15, HttpStatus.NOT_FOUND, "wallet.for.account.not.found"),
    CATEGORY_FOR_COMPANY_ID_NOT_FOUND(16, HttpStatus.NOT_FOUND, "category.for.company.id.not.found");

    private final Integer code;
    private final HttpStatus status;
    private final String message;

    public ExceptionPayload get() {
        return new ExceptionPayload(code, status, message);
    }
}
