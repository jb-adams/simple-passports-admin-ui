package org.ga4gh.passports.refimpl.admin.utils.filesystem;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtils {

    private static final String HOME_DIR = System.getenv("HOME");
    private static final String CONFIG_DIR = Paths.get(".ga4gh", ".simple-passports").toString();
    private static final String BROKERS_DIR = "brokers";

    public PathUtils() {

    }

    public Path getConfigDir() {
        return Paths.get(HOME_DIR, CONFIG_DIR);
    }

    public Path getBrokersDir() {
        return Paths.get(getConfigDir().toString(), BROKERS_DIR);
    }

    public Path getBrokerDir(String brokerName) {
        return Paths.get(getBrokersDir().toString(), brokerName);
    }

    public Path getBrokerDetailsFile(String brokerName) {
        return Paths.get(getBrokerDir(brokerName).toString(), "brokerDetails.json");
    }

    public Path getUserPoolFile(String brokerName) {
        return Paths.get(getBrokerDir(brokerName).toString(), "userPool.json");
    }
}
