package com.rw.finance.common.pass.jdsoft.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * key的初始工具类
 * 
 * @author zhengzhq
 *
 */
public class KeyInitialzer {

  public static final String ALGORITHM_RSA = "RSA";
  public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";
  /**
   * public key
   */
  private static final String PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAo075xGMONyYrYhKDFv3jjvL6Wz2kuyulM1iby9Vu4qIAxlGtrlgC1LgDaJlJgTI0E6qI9po8PaD0zdbWocGtvIWFFztZ926ir4lAO/cv0jpr+HqVXzOSfJYPWyndbpB4+R1/kJUKG+iUWhJ8ypxHVI7mjeaApjCjMUof4a5i7QcIzPJitm7v/f09cI8ad+1Qc+oxXhRjqVTN9vQjauwffENnYXytKnqizKHdHK8fIl37tYKeo4vdQJdZaxxSg/rVsWQ7ZNttWKxWDFFKdI3pduoAVXBBZRirIMvXS6mFq+9R9aAMy9Dw4pL4zOrivzw6b2DSwks/TTSpt5g/mg0xwwIDAQAB";
  /**
   * private key
   */
  private static final String PRIVATE_KEY="MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCjTvnEYw43JitiEoMW/eOO8vpbPaS7K6UzWJvL1W7iogDGUa2uWALUuANomUmBMjQTqoj2mjw9oPTN1tahwa28hYUXO1n3bqKviUA79y/SOmv4epVfM5J8lg9bKd1ukHj5HX+QlQob6JRaEnzKnEdUjuaN5oCmMKMxSh/hrmLtBwjM8mK2bu/9/T1wjxp37VBz6jFeFGOpVM329CNq7B98Q2dhfK0qeqLMod0crx8iXfu1gp6ji91Al1lrHFKD+tWxZDtk221YrFYMUUp0jel26gBVcEFlGKsgy9dLqYWr71H1oAzL0PDikvjM6uK/PDpvYNLCSz9NNKm3mD+aDTHDAgMBAAECggEBAIF06ao0m+A78cgcxK5FNU7sbmpFw4BcaOj7JQXAe9ZMdjDALt42Boh6FrmkShCQq5eraEeUnIx+O5Gw7RPtZLw9W/O+qOLsYSqlsrXWjaIpjc273w1I5Ka+jg3GcjJjdIKGT8ldXFYjWPbOEP7MQ/9UCJAUWYdkpvk7uWo9w04BLrwlxsVu4fyW62zG4B0zJ7ftIhTEjyioEcNa25O6eXOBS1iMuNDbEHZh4MeVYow0q7US281e2zwrI0LsjvuMEYHqdcqAONsO+vrHE27PYXgitNzOqXnz4DVZpSZRcF9qNvNueRKPmln0aAWJuDN2XhREerhcpKDBQ9d+pLW6zgECgYEA6DRbyudFGR15D67vUEThU2pbDU9gHbPm6pkTW9Fc1/DGM2uuF6cZYNJCUo5oSQgf6BaQRYtJzLRk3WK80tqY39JexsKyXVZ55tOxzO8+Noku1QNyvMh7vxGL3E30+NCQHpxlHx6p4SsACLnlrGKWkkGaEtCPuuGu6TMF1NpSaJMCgYEAtAszyiJQW0ZqR3DMvr9KaDU2tatUnlq0ow3evCy6V1K/rCVPFvvU1WfLXJ+DQhu0dVZC65UDL2Y+J+r3QpkWNTD1QUhol7gMAjakTvmW5FNWgLVkiJcbadiQWPiMTs3WdQkZmHFtKsqo7MrzP10gkGUcYI+d4zNvz7Dyn3kCwBECgYEAymvSVVg0sUczIMvkDTpunxQJGdpHNL1+oKYe7Rze7dQURAEru6zMf83rSSKhoIC3p8/7ptRc2lmr0B5h8wHi4ML4IhbZ/GoFTIbg6YDp4ArIy6L847t1vMOkA8Hluv29lSHLOUy21PZySikcIaG0Fv2fPaWYllZk7x+uhrZnvocCgYBVsN89XYeRabo7tlw8jR8E6g7X+GuV0uYWlQtl1IP7+85uSHOUJNfvmi8YLnNyi20gS6YeKhYSAT+kEBkPAX2oY1zXbXcafuZ4Rzl8vR4sHd4V9D+dIw5RGlnZfrKI7z8bBPHBtHqY20v7J70Oc2yETRtsee5TrK+S0k0nyZidgQKBgQCz3mwon2uK3L+LEhcscL26iaUxpOtKTF3beEDFM42HIrlHCAt9F2MZzqzZcVfaEMayz6VSBuAxrCpGdCgoVf+KzwzwGGmECcNRT2MxNribI0e/2KEhFRyfXZm2A/z0em3H78zYZTYIIwyFat3pvC6quVDdZDJIkFhf/iNpA7Mcug==";

  /**
   * 初始化公有key
   * 
   * @param keyFile key文件
   * @param algorithm 算法
   * @return
   * @throws Exception
   */
  public static RSAPublicKey initPublicKey(File keyFile) throws Exception {
    return initPublicKey(readKeyFileToString(keyFile));
  }

  /**
   * 初始化公有key
   * 
   * @param publicKey 公有key
   * @param algorithm 算法
   * @return
   * @throws Exception
   */
  public static RSAPublicKey initPublicKey(String publicKey) {
    try {
      X509EncodedKeySpec pubX509 = new X509EncodedKeySpec(Base64.decodeBase64(KeyInitialzer.PUBLIC_KEY));
      KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);

      return (RSAPublicKey) keyFactory.generatePublic(pubX509);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 初始化私有key
   * 
   * @param keyFile key文件
   * @param algorithm 算法
   * @return
   * @throws Exception
   */
  public static RSAPrivateKey initPrivateKey() {
    return initPrivateKey(KeyInitialzer.PRIVATE_KEY);
  }

  /**
   * 初始化私有key
   * 
   * @param privateKey 私有key
   * @param algorithm 算法
   * @return
   * @throws Exception
   */
  public static RSAPrivateKey initPrivateKey(String privateKey) {
    try {
      PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
      KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);

      return (RSAPrivateKey) keyFactory.generatePrivate(priPKCS8);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 读取加密文件并返回内容，过滤--部分
   * 
   * @param keyFile
   * @return
   */
  private static String readKeyFileToString(File keyFile) {
    BufferedReader reader = null;

    try {
      reader = new BufferedReader(new InputStreamReader(new FileInputStream(keyFile)));
      StringBuilder builder = new StringBuilder();
      String readLine = null;
      while ((readLine = reader.readLine()) != null) {
        if (readLine.charAt(0) == '-') {
          continue;
        } else {
          builder.append(readLine);
          builder.append('\r');
        }
      }

      return builder.toString();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
