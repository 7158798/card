package com.rw.finance.common.pass.jdsoft.utils;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

public class HttpInvoker {

  public static CloseableHttpClient DEFAULT_HTTP_INVOKER = null;
  private static RequestConfig REQUEST_CONFIG =
      RequestConfig.custom().setSocketTimeout(15000).setConnectTimeout(15000).build(); // 设置请求和传输超时时间

  public static void initInvoker() throws Exception {
    SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
      // 信任所有
      public boolean isTrusted(X509Certificate[] chain, String authType)
          throws CertificateException {
        return true;
      }
    }).build();
    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);

    // 创建默认的http invoker,并禁用重定向. UserAgent需要设置,否则Nginx有做拦截
    DEFAULT_HTTP_INVOKER =
        HttpClients.custom().setDefaultRequestConfig(REQUEST_CONFIG).setSSLSocketFactory(sslsf)
            .setUserAgent(
                "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36")
            .disableRedirectHandling().build();

  }

  // 静态块初始化
  static {
    try {
      initInvoker();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static String doPost(String url, List<NameValuePair> paramList) {
    try {
      HttpPost post = new HttpPost(new URIBuilder(url).build());
      if (paramList != null && !paramList.isEmpty()) {
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "UTF-8");
        post.setEntity(entity);
      }

      CloseableHttpResponse response = DEFAULT_HTTP_INVOKER.execute(post);
      if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
        throw new RuntimeException("服务异常");
      }
      String respStr = EntityUtils.toString(response.getEntity());
      response.close();

      return respStr;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
}
