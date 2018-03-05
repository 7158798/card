package com.rw.finance.admin.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.rw.finance.admin.BaseTest;

public class AgentInfoControllerTest extends BaseTest{

	MockMvc mvc;  
	  
    @Autowired  
    WebApplicationContext webApplicationConnect;  
    
    @Test
    public void saveAgentInfo(){
    	try {
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/agent/saveagentinfo").accept(MediaType.APPLICATION_JSON)).andReturn();
			mvcResult.getAsyncResult();
		} catch (Exception e) {
			e.printStackTrace();
		} 
    }
    
    
}
