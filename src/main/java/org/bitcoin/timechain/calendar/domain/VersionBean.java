package org.bitcoin.timechain.calendar.domain;

import static org.bitcoin.timechain.calendar.AppConstants.JUST_A_DATE;
import static org.bitcoin.timechain.calendar.AppConstants.JUST_A_TIME;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class VersionBean {

    public static final String VERSION = "v1";

    private final String version;

    public VersionBean() {
        this.version = VERSION;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime lastUpdate = VERSION_DATE;

    public static final LocalDateTime VERSION_DATE = LocalDate.parse(JUST_A_DATE).atTime(LocalTime.parse(JUST_A_TIME));

}
