package org.ga4gh.passports.refimpl.admin;

import org.ga4gh.passports.refimpl.admin.utils.filesystem.PathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    @Autowired
    PathUtils pathUtils;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
