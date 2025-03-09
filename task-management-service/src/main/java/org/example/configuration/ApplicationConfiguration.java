package org.example.configuration;

import org.example.exception.TaskManagementGLobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public TaskManagementGLobalExceptionHandler walletGlobalExceptionHandler(Environment environment) {
        return new TaskManagementGLobalExceptionHandler();
    }
}
