package org.bitcoin.timechain.calendar.controller;

import static org.bitcoin.timechain.calendar.AppConstants.SLASH;
import static org.bitcoin.timechain.calendar.domain.VersionBean.VERSION;

import org.bitcoin.timechain.calendar.config.ApplicationYmlConfig;
import org.bitcoin.timechain.calendar.exception.DocumentNotFoundException;
import org.bitcoin.timechain.calendar.service.BitcoinTimechainCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(SLASH + VERSION)
@Slf4j
public class BitcoinTimechainCalendarController {

    private final ApplicationYmlConfig applicationYmlConfig;
    private final BitcoinTimechainCalendarService bitcoinTimechainCalendarService;

    @Autowired
    public BitcoinTimechainCalendarController(final ApplicationYmlConfig applicationYmlConfig,
            final BitcoinTimechainCalendarService bitcoinTimechainCalendarService) {
        this.applicationYmlConfig = applicationYmlConfig;
        this.bitcoinTimechainCalendarService = bitcoinTimechainCalendarService;
    }

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
    }

    @GetMapping("/blocks")
    public ResponseEntity<byte[]> getLatterBlockchainBlocks() throws DocumentNotFoundException {
        // start
        final StopWatch stopWatch = new StopWatch("BitcoinTimechainCalendarController.getLatterBlockchainBlocks");
        stopWatch.start();

        // do
        final byte[] jsonInBytes = bitcoinTimechainCalendarService.getJson(applicationYmlConfig.getUrlToCall());

        // end
        stopWatch.stop();
        log.info(stopWatch.shortSummary());

        return new ResponseEntity<>(jsonInBytes, HttpStatus.OK);
    }
}
