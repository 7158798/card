package com.rw.finance.admin.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.rw.finance.admin.annotation.AgentInfoAuthor;
import com.rw.finance.admin.dao.AgentInfoDao;
import com.rw.finance.common.constants.JwtConstants;
import com.rw.finance.common.entity.AgentInfo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.Method;

/**
 * @author huanghongfei
 * @file AgentInfoAuthorInterceptor.java
 * @date 2017年12月9日 下午1:17:13
 * @declaration
 */
@Component
public class AgentInfoAuthorInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private AgentInfoDao agentInfoDao;

    // 处理请求
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        // 取得方法
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 判断标记
        if (method.isAnnotationPresent(AgentInfoAuthor.class)) {
            // 授权码
            String jwt = request.getParameter("jwt");
            Jws<Claims> claims = Jwts.parser().setSigningKey(JwtConstants.JWT_SECURE).parseClaimsJws(jwt);

            // 代理信息
            AgentInfo proxy = agentInfoDao.findOne(Long.valueOf(claims.getBody().get("agentid").toString()));
            if (StringUtils.isEmpty(proxy)) {
                response.setStatus(401);
                return false;
            }

            // 超级权限
            if (method.getAnnotation(AgentInfoAuthor.class).level() == 0) {
                if (proxy.getAgentlevel() > 0) {
                    return false;
                } else {
                    return true;
                }
            }

            // 判断权限
            int level = Integer.valueOf(claims.getBody().get("powerlevel").toString());
            if (level > method.getAnnotation(AgentInfoAuthor.class).level()) {
                response.setStatus(401);
                return false;
            }
        }

        return true;
    }
}
