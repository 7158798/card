package com.rw.finance.common.pass.jdsoft.utils;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.binary.Base64;

/**
 * RSA签名、验签、加密以及解密
 * 
 * @author zhengzhq
 *
 */
public class RSAHelper {

  // 签名算法
  public static final String SIGN_ALGORITHMS = "SHA1WithRSA";
  public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";

  /**
   * 利用私钥生成签名
   * 
   * @param data 要签名的数据
   * @param privateKey 私有key
   * @return
   * @throws Exception
   */
  public static String getSign(String data, PrivateKey privateKey) {
    try {
      Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
      signature.initSign(privateKey);
      signature.update(data.getBytes(CharEncoding.UTF_8));

      return new String(Base64.encodeBase64(signature.sign()), CharEncoding.UTF_8);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 利用公钥验证签名
   * 
   * @param data 原始数据
   * @param sign 需要验证的签名
   * @param publicKey 公钥
   * @return
   */
  public static boolean verifySign(String data, String sign, PublicKey publicKey) {
    try {
      Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
      signature.initVerify(publicKey);
      signature.update(data.getBytes(CharEncoding.UTF_8));

      return signature.verify(Base64.decodeBase64(sign));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 加密
   * 
   * @param data
   * @param publicKey
   * @return
   */
  public static String encryptWithPKCS1(String source, RSAPublicKey key) {
    return encrypt(source, key, CIPHER_ALGORITHM);
  }

  public static String encrypt(String source, RSAPublicKey key, String algorithm) {
    ByteArrayOutputStream out = null;
    try {
      int maxEncryptBlock = key.getModulus().bitLength() / 8 - 11;
      // 对数据加密
      Cipher cipher = Cipher.getInstance(algorithm);
      cipher.init(Cipher.ENCRYPT_MODE, key);
      byte[] data = source.getBytes(CharEncoding.UTF_8);
      int inputLen = data.length;
      int offSet = 0;
      byte[] cache;
      int i = 0;
      out = new ByteArrayOutputStream();
      // 对数据分段加密
      while (inputLen - offSet > 0) {
        if (inputLen - offSet > maxEncryptBlock) {
          cache = cipher.doFinal(data, offSet, maxEncryptBlock);
        } else {
          cache = cipher.doFinal(data, offSet, inputLen - offSet);
        }
        out.write(cache, 0, cache.length);
        i++;
        offSet = i * maxEncryptBlock;
      }
      return new String(Base64.encodeBase64(out.toByteArray()));
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      closeQuietly(out);
    }
  }

  /**
   * 解密
   * 
   * @param data
   * @param privateKey
   * @return
   */
  public static String decryptWithPKCS1(String data, RSAPrivateKey key) {
    return decrypt(data, key, CIPHER_ALGORITHM);
  }

  public static String decrypt(String data, RSAPrivateKey key, String algorighm) {
    ByteArrayOutputStream out = null;
    try {
      int maxDecryptBlock = key.getModulus().bitLength() / 8;
      byte[] encryptedData = Base64.decodeBase64(data);
      Cipher cipher = Cipher.getInstance(algorighm);
      cipher.init(Cipher.DECRYPT_MODE, key);
      int inputLen = encryptedData.length;
      out = new ByteArrayOutputStream();
      int offSet = 0;
      byte[] cache;
      int i = 0;
      // 对数据分段解密
      while (inputLen - offSet > 0) {
        if (inputLen - offSet > maxDecryptBlock) {
          cache = cipher.doFinal(encryptedData, offSet, maxDecryptBlock);
        } else {
          cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
        }
        out.write(cache, 0, cache.length);
        i++;
        offSet = i * maxDecryptBlock;
      }
      return new String(out.toByteArray());
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      closeQuietly(out);
    }
  }

  private static void closeQuietly(OutputStream os) {
    if (os != null) {
      try {
        os.close();
      } catch (Exception e) {

      }
    }
  }
}
