package org.bitcoin.timechain.calendar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties("web")
public class ApplicationYmlConfig {

    private String version;
}
