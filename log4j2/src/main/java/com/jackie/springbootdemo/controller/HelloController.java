package com.jackie.springbootdemo.controller;

import com.jackie.springbootdemo.annotation.DemoAnnotation;
//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class HelloController {
    //private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);
    private static final Logger LOG = LogManager.getLogger();
    @GetMapping(value = "/index")
    public String index(HttpServletRequest request) {
        LOG.info("============打印日志开始============");
        LOG.info("URL: " + request.getRequestURL().toString());
        LOG.info("============打印日志结束============");
        return "hello jackie";
    }

    @PostMapping(value = "/test1")
    public String test1(HttpServletRequest request, String var1) {
        LOG.info("============打印日志开始============");
        LOG.info("URL: " + request.getRequestURL().toString());
        LOG.info("============打印日志结束============");
        String var2 = request.getHeader("cmd");
        return "test1+"+var1+"+"+var2;
    }

    @GetMapping(value="/hello")
    public String hello(HttpServletRequest request,String payload) {
        //System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        //System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        String payload1 = request.getHeader("cmd");
        LOG.info(payload1);
        LOG.error(payload1);
        //LOG.error("{}", payload1);
        //LOG.info("{}", payload1);
        return "ok and your payload is : "+payload1;
    }
    @DemoAnnotation
    @GetMapping(value = "/test2")
    public String test2(HttpServletRequest request, String var1, String var2) {
//        LOG.info("============打印日志开始============");
//        LOG.info("URL: " + request.getRequestURL().toString());
//        LOG.info("============打印日志结束============");
//        int i = 1/0;
        if (1<2)
            throw new IllegalArgumentException("exception");
        return "test2";
    }
}
