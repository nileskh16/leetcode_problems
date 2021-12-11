package com.plural.spring.fundamentals.problems.strings;

public class ValidIPAddress {

    public static final String NEITHER = "Neither";
    public static final String IPV4 = "IPv4";
    public static final String IPV6 = "IPv6";
    private static final String REGEX = "abcdefABCDEF";

    public String validIPAddress(String queryIP) {
        if (queryIP.isEmpty()) return NEITHER;
        if (isValidIPv4(queryIP)) return IPV4;
        else if (isValidIPv6(queryIP)) return IPV6;
        else return NEITHER;
    }

    private boolean isValidIPv4(String address) {
        if (address.charAt(address.length() - 1) == '.') return false;
        String[] subParts = address.split("\\.");
        if (subParts.length != 4) return false;
        try {
            for (String part : subParts) {
                if (part.length() > 3
                        || part.length() <= 0
                        || (part.length() != 1 && part.charAt(0) == '0')) return false;
                int id = Integer.parseInt(part);
                if (id > 255 || id < 0) return false;
            }
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    private boolean isValidIPv6(String address) {
        if (address.charAt(address.length() - 1) == ':') return false;
        String[] subParts = address.split(":");
        if (subParts.length != 8) return false;
        for (String part : subParts) {
            if (part.length() > 4 || part.length() <= 0
                    || !isValidHostId(part)) return false;
        }
        return true;
    }

    private boolean isValidHostId(String hostId) {
        for (Character ch : hostId.toCharArray()) {
            if (!Character.isDigit(ch) && !REGEX.contains(ch.toString())) return false;
        }
        return true;
    }
}
