package org.bitcoin.timechain.calendar.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.bitcoin.timechain.calendar.exception.ConnectionException;
import org.bitcoin.timechain.calendar.exception.DocumentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ApiExceptionHandlerControllerTest {

    ApiExceptionHandlerController apiExceptionHandlerController;

    @BeforeEach
    void init() {
        apiExceptionHandlerController = new ApiExceptionHandlerController();
    }

    @Test
    void testIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("no input parameter");
        });
        assertThat(exception.getMessage(), is("no input parameter"));
    }

    @Test
    void testConnectionException() {
        ConnectionException exception = assertThrows(ConnectionException.class, () -> {
            throw new ConnectionException("connection exception", null);
        });
        assertThat(exception.getMessage(), is("connection exception"));
    }

    @Test
    void testDocumentNotFoundException() {
        DocumentNotFoundException exception = assertThrows(DocumentNotFoundException.class, () -> {
            throw new DocumentNotFoundException("not found", null);
        });
        assertThat(exception.getMessage(), is("not found"));
    }

    @Test
    void testHandleError() {
        final ResponseEntity<String> result = apiExceptionHandlerController.handleError(HttpStatus.NOT_FOUND,
                new DocumentNotFoundException("This is just a 404 Test", null));
        assertThat(result.getBody(), is("This is just a 404 Test"));
        assertThat(result.getStatusCode(), is(HttpStatus.NOT_FOUND));
    }
}
