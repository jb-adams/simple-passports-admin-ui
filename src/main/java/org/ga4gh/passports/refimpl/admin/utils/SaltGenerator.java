package org.ga4gh.passports.refimpl.admin.utils;

import java.util.Random;

public class SaltGenerator {

    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String getSaltString() {
        int nChars = 32;
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < nChars; i++) {
            int randI = (int) (rnd.nextFloat() * ALPHABET.length());
            salt.append(ALPHABET.charAt(randI));
        }
        return salt.toString();
    }
}
