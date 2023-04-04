package com.dzt.test.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;

@Component
public class Service {

    private static final Logger logger = Logger.getLogger(Service.class);



    @Autowired
    public  LoginService loginService;


    public  LoginService getLoginService() {
        return loginService;
    }
}
