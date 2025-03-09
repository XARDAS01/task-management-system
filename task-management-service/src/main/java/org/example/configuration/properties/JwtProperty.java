package org.example.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "task-management.security.jwt")
public class JwtProperty {

    private String secret;
}
