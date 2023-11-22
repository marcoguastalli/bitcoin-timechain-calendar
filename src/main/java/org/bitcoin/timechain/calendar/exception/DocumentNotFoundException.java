package org.bitcoin.timechain.calendar.exception;

/** Exception for document not found */
public class DocumentNotFoundException extends Exception {

    public DocumentNotFoundException(final String message, Throwable cause) {
        super(message, cause);
    }

}
