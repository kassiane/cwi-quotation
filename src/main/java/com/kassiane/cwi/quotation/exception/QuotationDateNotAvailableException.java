package com.kassiane.cwi.quotation.exception;

/**
 * Exception that is thrown when quotation date is not available (Example:
 * holidays).
 *
 * @author kassi
 *
 */
public class QuotationDateNotAvailableException extends RuntimeException {

    private static final long serialVersionUID = 7276666264188583867L;

    public QuotationDateNotAvailableException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public QuotationDateNotAvailableException(final String message, final Throwable cause, final boolean enableSuppression,
            final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public QuotationDateNotAvailableException(final String message, final Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public QuotationDateNotAvailableException(final String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public QuotationDateNotAvailableException(final Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
