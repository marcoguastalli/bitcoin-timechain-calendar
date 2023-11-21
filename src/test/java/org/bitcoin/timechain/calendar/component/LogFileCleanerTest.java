package org.bitcoin.timechain.calendar.component;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LogFileCleanerTest {

    @Mock
    LogFileCleaner logFileCleaner;

    @Test
    void testCreateXMLGregorianCalendarFromDate() throws IOException {
        assertThat(logFileCleaner, notNullValue());
        logFileCleaner.deleteLogFile();
        verify(logFileCleaner, times(1)).deleteLogFile();
    }
}
