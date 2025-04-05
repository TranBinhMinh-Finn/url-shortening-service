package com.finn.urlshorteningservice.utils;

import java.math.BigInteger;

public class Base58Encoder {
    public static final String alphabet = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";

    public static String encode(BigInteger input) {
        StringBuilder output = new StringBuilder();
        BigInteger temp = input;
        while (temp.compareTo(BigInteger.ZERO) > 0) {
            BigInteger remainder = temp.remainder(BigInteger.valueOf(58));
            temp = temp.divide(BigInteger.valueOf(58));
            output.append(alphabet.charAt(remainder.intValue()));
        }
        output.reverse();
        return output.toString();
    }
}
