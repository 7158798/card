package com.rw.finance.common.pass.eynon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rw.finance.common.pass.eynon.utils.Digest;

public class MessageDigest implements Digest {
    private static final Logger log = LoggerFactory.getLogger(MessageDigest.class);
    private String algorithm;
    private String provider;

    public MessageDigest(final String algorithm, final String provider) {
        this.algorithm = algorithm;
        this.provider = provider;
    }

    public MessageDigest(final String algorithm) {
        this(algorithm, null);
    }

    public void setProvider(final String provider) {
        this.provider = provider;
    }

    @Override
    public byte[] sign(final byte[] bytes) throws Exception {
        try {
            final java.security.MessageDigest digit = (this.provider == null) ? java.security.MessageDigest.getInstance(this.algorithm) : java.security.MessageDigest.getInstance(this.algorithm, this.provider);
            digit.update(bytes);
            return digit.digest();
        } catch (Exception e) {
            throw new Exception("BUILD SIGNATURE FAIL", e);
        }
    }

    @Override
    public boolean verify(final byte[] bytes, final byte[] signedArray) {
        try {
            return isEqual(this.sign(bytes), signedArray);
        } catch (Exception e) {
            log.error("验证异常：", e);
            return false;
        }
    }

    private static boolean isEqual(byte[] digesta, byte[] digestb) {
        if (digesta.length != digestb.length) {
            return false;
        }
        int result = 0;
        for (int i = 0; i < digesta.length; i++) {
            result |= digesta[i] ^ digestb[i];
        }
        return result == 0;
    }
}