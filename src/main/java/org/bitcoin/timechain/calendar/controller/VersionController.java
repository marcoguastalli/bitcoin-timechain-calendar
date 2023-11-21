package org.bitcoin.timechain.calendar.controller;

import static org.bitcoin.timechain.calendar.AppConstants.SLASH;
import static org.bitcoin.timechain.calendar.domain.VersionBean.VERSION;

import org.bitcoin.timechain.calendar.config.ApplicationYmlConfig;
import org.bitcoin.timechain.calendar.domain.JsonResponseResult;
import org.bitcoin.timechain.calendar.domain.VersionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(SLASH + VERSION)
@Slf4j
public class VersionController {

    private final ApplicationYmlConfig applicationYmlConfig;

    @Autowired
    public VersionController(final ApplicationYmlConfig applicationYmlConfig) {
        this.applicationYmlConfig = applicationYmlConfig;
    }

    @GetMapping("/version")
    public ResponseEntity<JsonResponseResult> releaseNotes() {
        // start
        final StopWatch stopWatch = new StopWatch("VersionController.releaseNotes");
        stopWatch.start();

        // do
        final VersionBean versionBean = new VersionBean();
        log.debug("Version: {}", applicationYmlConfig.getVersion());

        // end
        stopWatch.stop();
        log.info(stopWatch.shortSummary());

        return ResponseEntity.ok(new JsonResponseResult(versionBean));
    }
}
