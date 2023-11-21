package org.bitcoin.timechain.calendar.controller;

import static org.bitcoin.timechain.calendar.AppConstantsTest.JUST_A_TIMESTAMP;
import static org.bitcoin.timechain.calendar.domain.VersionBean.VERSION;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.bitcoin.timechain.calendar.config.ApplicationYmlConfig;
import org.bitcoin.timechain.calendar.domain.JsonResponseResult;
import org.bitcoin.timechain.calendar.domain.VersionBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class VersionControllerTest {

    @Autowired
    ApplicationYmlConfig applicationYmlConfig;

    VersionController versionController;

    @BeforeEach
    void init() {
        versionController = new VersionController(applicationYmlConfig);
    }

    @Test
    void testReleaseNotes() {
        final ResponseEntity<JsonResponseResult> response = versionController.releaseNotes();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final JsonResponseResult jsonResponseResult = response.getBody();
        assertThat(jsonResponseResult, notNullValue());
        final VersionBean versionBean = (VersionBean) jsonResponseResult.getResult();
        assertThat(versionBean, notNullValue());
        assertThat(versionBean.getVersion(), is(VERSION));
        assertThat(versionBean.getLastUpdate().toString(), is(JUST_A_TIMESTAMP));
    }

}
