package com.rw.finance.admin;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 
 * @file BaseTest.java	
 * @author huanghongfei
 * @date 2017年12月9日 下午6:35:01
 * @declaration
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@WebAppConfiguration
public abstract class BaseTest {

}
