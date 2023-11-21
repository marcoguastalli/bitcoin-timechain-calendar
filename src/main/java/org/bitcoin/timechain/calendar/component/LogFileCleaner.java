package org.bitcoin.timechain.calendar.component;

import static org.bitcoin.timechain.calendar.AppConstants.LOGS_FOLDER;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class LogFileCleaner {

    @PostConstruct
    public void deleteLogFile() throws IOException {
        try (var dirStream = Files.walk(Paths.get(LOGS_FOLDER))) {
            dirStream.filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .filter(file -> !file.isHidden())
                    .forEach(File::deleteOnExit);
        }
    }
}
