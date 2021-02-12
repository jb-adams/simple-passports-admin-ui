package org.ga4gh.passports.refimpl.admin;

import org.ga4gh.passports.refimpl.admin.utils.filesystem.DirUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ConfigurationProperties
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public DirUtils getDirUtils() {
        return new DirUtils();
    }
}
