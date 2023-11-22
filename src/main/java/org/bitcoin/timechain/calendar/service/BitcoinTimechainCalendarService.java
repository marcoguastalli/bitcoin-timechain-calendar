package org.bitcoin.timechain.calendar.service;

import org.bitcoin.timechain.calendar.exception.DocumentNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BitcoinTimechainCalendarService {
    private final RestTemplate restTemplate;

    public BitcoinTimechainCalendarService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public byte[] getJson(@NonNull final String url) throws DocumentNotFoundException {
        try {
            log.info("Call url: {}", url);
            return restTemplate.getForObject(url, byte[].class);
        } catch (RestClientResponseException e) {
            final String message = String.format("Error get response from url: %s", url);
            log.error(message);
            throw new DocumentNotFoundException(message, e);
        }
    }
}
