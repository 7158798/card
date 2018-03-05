package com.rw.finance.admin.interceptor;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.rw.finance.admin.service.LogInfoService;
import com.rw.finance.common.constants.JwtConstants;
import com.rw.finance.common.constants.LogInfoRoleConstants;
import com.rw.finance.common.entity.LogInfo;
import com.rw.finance.common.utils.DateUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 代理操作拦截器
 * @file LogInfoInterceptor.java	
 * @author huanghongfei
 * @date 2017年12月9日 下午1:17:13
 * @declaration
 */
@Component
public class LogInfoInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private LogInfoService logInfoService;
	
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
    	String jwt=request.getParameter("jwt");
    	if(StringUtils.isEmpty(jwt)){
    		return true;
    	}
    	Jws<Claims> claims = Jwts.parser().setSigningKey(JwtConstants.JWT_SECURE).parseClaimsJws(jwt);
    	logInfoService.add(new LogInfo(LogInfoRoleConstants.Role.RoleAgent.getRole(), Long.valueOf(claims.getBody().get("agentid").toString()),request.getRequestURI(), request.getHeader("user-agent"),request.getMethod(),request.getQueryString(),"", 200,request.getRemoteHost(),"",DateUtils.getTimeStr(new Date())));
    	request.setAttribute("agentid",claims.getBody().get("agentid"));
        return true;
    }
}
