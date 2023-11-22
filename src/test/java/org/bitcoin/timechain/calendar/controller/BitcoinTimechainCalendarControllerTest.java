package org.bitcoin.timechain.calendar.controller;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.bitcoin.timechain.calendar.config.ApplicationYmlConfig;
import org.bitcoin.timechain.calendar.exception.DocumentNotFoundException;
import org.bitcoin.timechain.calendar.service.BitcoinTimechainCalendarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class BitcoinTimechainCalendarControllerTest {

    @SpyBean
    @Autowired
    ApplicationYmlConfig applicationYmlConfig;
    @Mock
    BitcoinTimechainCalendarService bitcoinTimechainCalendarService;
    BitcoinTimechainCalendarController bitcoinTimechainCalendarController;

    @BeforeEach
    void init() {
        bitcoinTimechainCalendarController = new BitcoinTimechainCalendarController(applicationYmlConfig, bitcoinTimechainCalendarService);
    }

    @Test
    void testGetLatterBlockchainBlocks() throws DocumentNotFoundException {
        // when
        when(bitcoinTimechainCalendarService.getJson(anyString())).thenReturn(new byte[1]);
        // given
        final ResponseEntity<byte[]> response = bitcoinTimechainCalendarController.getLatterBlockchainBlocks();
        // then
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(new byte[1]));
        verify(applicationYmlConfig, times(1)).getUrlToCall();
        verify(bitcoinTimechainCalendarService, times(1)).getJson(anyString());
    }
}
