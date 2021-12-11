package com.plural.spring.fundamentals.problems.strings;

import org.junit.Assert;
import org.junit.Test;

public class TestValidIPAddress {

    private final ValidIPAddress validIPAddress;

    public TestValidIPAddress() {
        validIPAddress = new ValidIPAddress();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(ValidIPAddress.IPV4, validIPAddress.validIPAddress("172.16.254.1"));
        Assert.assertEquals(ValidIPAddress.IPV4, validIPAddress.validIPAddress("192.168.1.0"));
        Assert.assertEquals(ValidIPAddress.NEITHER, validIPAddress.validIPAddress("192.168.01.1"));
        Assert.assertEquals(ValidIPAddress.NEITHER, validIPAddress.validIPAddress("192.168.1.00"));
        Assert.assertEquals(ValidIPAddress.NEITHER, validIPAddress.validIPAddress("192.168.@1.1"));
        Assert.assertEquals(ValidIPAddress.NEITHER, validIPAddress.validIPAddress("256.168.1.1"));
        Assert.assertEquals(ValidIPAddress.NEITHER, validIPAddress.validIPAddress("1e1.4.5.6"));
        Assert.assertEquals(ValidIPAddress.NEITHER, validIPAddress.validIPAddress("1e1.4.5.6."));
        Assert.assertEquals(ValidIPAddress.IPV6, validIPAddress.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
        Assert.assertEquals(ValidIPAddress.IPV6, validIPAddress.validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"));
        Assert.assertEquals(ValidIPAddress.IPV6, validIPAddress.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        Assert.assertEquals(ValidIPAddress.IPV6, validIPAddress.validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"));
        Assert.assertEquals(ValidIPAddress.NEITHER, validIPAddress.validIPAddress("2001:0db8:85a3::8A2E:037j:7334"));
        Assert.assertEquals(ValidIPAddress.NEITHER, validIPAddress.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
        Assert.assertEquals(ValidIPAddress.NEITHER, validIPAddress.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}
