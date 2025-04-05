package com.finn.urlshorteningservice.utils;

import java.math.BigInteger;

public class StringConverter {
    public static BigInteger convertByAsciiToDecimal(String input) {
        BigInteger output = BigInteger.ZERO;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            output = output.multiply(BigInteger.valueOf(256));
            output = output.add(BigInteger.valueOf(c));
        }

        return output;
    }
}
