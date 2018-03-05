package com.rw.finance.common.utils;

import com.rw.finance.common.constants.JwtConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.Map;

public class JwtUtil {

    /**
     * token生成器
     *
     * @param headerParams 请求头参数列表
     * @param bodyParams   请求体参数列表
     * @return token
     */
    public static String tokenGenerator(Map<String, Object> headerParams, Map<String, Object> bodyParams) {
        DateTime dt = new DateTime();
        Date expiratime = dt.plusDays(JwtConstants.JWT_EXPIRATION_DAY).toDate();
        bodyParams.put("creatime", DateUtils.getTimeStr(new Date()));
        bodyParams.put("expiratime", expiratime);
        String token = Jwts.builder()
                .setHeaderParams(headerParams)
                .setClaims(bodyParams)
                .signWith(SignatureAlgorithm.HS256, JwtConstants.JWT_SECURE)
                .compact();
        return token;
    }
}
