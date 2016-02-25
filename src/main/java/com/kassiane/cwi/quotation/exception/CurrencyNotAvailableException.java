package com.kassiane.cwi.quotation.exception;

/**
 * Exception that is thrown when a currency is not available.
 *
 * @author kassi
 *
 */
public class CurrencyNotAvailableException extends RuntimeException {

    private static final long serialVersionUID = -1648884231448028699L;

    public CurrencyNotAvailableException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CurrencyNotAvailableException(final String message, final Throwable cause, final boolean enableSuppression,
            final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public CurrencyNotAvailableException(final String message, final Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public CurrencyNotAvailableException(final String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public CurrencyNotAvailableException(final Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
