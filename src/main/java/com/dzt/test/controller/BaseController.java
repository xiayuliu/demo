package com.dzt.test.controller;

import com.dzt.test.service.Service;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class BaseController {

    public static final Logger log = Logger.getLogger(BaseController.class);

    @Autowired
    public Service service;


}
