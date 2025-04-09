package com.finn.urlshorteningservice;

import com.finn.urlshorteningservice.utils.Base58Encoder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

public class Base58Test {

    @Test
    void normalScenarioTest()
    {
        BigInteger input = BigInteger.valueOf(123456789L);
        String output = "BukQL";

        System.out.println(Base58Encoder.encode(input));

        assert output.equals(Base58Encoder.encode(input));
    }
}
