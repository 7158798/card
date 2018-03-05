package com.rw.finance.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author huanghongfei
 * @date 2017年12月7日
 * @declaration
 */
@EnableTransactionManagement
@SpringBootApplication
@EntityScan(value = "com.rw.finance.common.entity")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
