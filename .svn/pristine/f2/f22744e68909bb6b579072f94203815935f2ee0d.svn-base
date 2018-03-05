package com.rw.finance.common.pass.eynon.utils;

public abstract class Base64 {
    private static char[] alphabet;
    private static byte[] codes;

    static {
        Base64.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
        Base64.codes = new byte[256];
        for (int i = 0; i < 256; ++i) {
            Base64.codes[i] = -1;
        }
        for (int i = 65; i <= 90; ++i) {
            Base64.codes[i] = (byte) (i - 65);
        }
        for (int i = 97; i <= 122; ++i) {
            Base64.codes[i] = (byte) (26 + i - 97);
        }
        for (int i = 48; i <= 57; ++i) {
            Base64.codes[i] = (byte) (52 + i - 48);
        }
        Base64.codes[43] = 62;
        Base64.codes[47] = 63;
    }

    public static byte[] decode(final char[] data) throws Exception {
        return decode(data, true);
    }

    private static byte[] decode(final char[] data, final boolean checkLength) throws Exception {
        int tempLen = data.length;
        for (final char ch : data) {
            final int value = Base64.codes[ch & '\u00ff'];
            if (value < 0 && ch != '=') {
                --tempLen;
            }
        }
        int len = (tempLen + 3) / 4 * 3;
        if (tempLen > 0 && data[tempLen - 1] == '=') {
            --len;
        }
        if (tempLen > 1 && data[tempLen - 2] == '=') {
            --len;
        }
        final byte[] out = new byte[len];
        int shift = 0;
        int accum = 0;
        int index = 0;
        for (final char ch2 : data) {
            final int value2 = Base64.codes[ch2 & '\u00ff'];
            if (value2 >= 0) {
                accum <<= 6;
                shift += 6;
                accum |= value2;
                if (shift >= 8) {
                    shift -= 8;
                    out[index++] = (byte) (accum >> shift & 0xFF);
                }
            }
        }
        if (checkLength && index != out.length) {
            throw new Exception("Miscalculated data length (wrote " + index + " instead of " + out.length + ")");
        }
        return out;
    }

    public static char[] encode(final byte[] data) {
        final char[] out = new char[(data.length + 2) / 3 * 4];
        for (int i = 0, index = 0; i < data.length; i += 3, index += 4) {
            boolean quad = false;
            boolean trip = false;
            int val = 0xFF & data[i];
            val <<= 8;
            if (i + 1 < data.length) {
                val |= (0xFF & data[i + 1]);
                trip = true;
            }
            val <<= 8;
            if (i + 2 < data.length) {
                val |= (0xFF & data[i + 2]);
                quad = true;
            }
            out[index + 3] = Base64.alphabet[quad ? (val & 0x3F) : 64];
            val >>= 6;
            out[index + 2] = Base64.alphabet[trip ? (val & 0x3F) : 64];
            val >>= 6;
            out[index + 1] = Base64.alphabet[val & 0x3F];
            val >>= 6;
            out[index] = Base64.alphabet[val & 0x3F];
        }
        return out;
    }
}