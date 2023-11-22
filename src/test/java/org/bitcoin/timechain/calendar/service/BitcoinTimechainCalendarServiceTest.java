package org.bitcoin.timechain.calendar.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.bitcoin.timechain.calendar.exception.DocumentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class BitcoinTimechainCalendarServiceTest {
    @Mock
    RestTemplate restTemplate;
    @InjectMocks
    BitcoinTimechainCalendarService bitcoinTimechainCalendarService;

    @BeforeEach
    void init() {
        bitcoinTimechainCalendarService = new BitcoinTimechainCalendarService(restTemplate);
    }

    @Test
    void testGetJson() throws DocumentNotFoundException {
        // when
        when(restTemplate.getForObject(anyString(), eq(byte[].class))).thenReturn(new byte[27]);
        // given
        final byte[] imageInBytes = bitcoinTimechainCalendarService.getJson("/call");
        // then
        assertThat(imageInBytes, notNullValue());
        assertThat(imageInBytes.length, is(27));
    }
}
