package com.rw.finance.client;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * @file BaseTest.java	
 * @author huanghongfei
 * @date 2017年12月9日 下午6:35:40
 * @declaration
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public abstract class BaseTest {

}
