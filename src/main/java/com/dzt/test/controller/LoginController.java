package com.dzt.test.controller;


import com.alibaba.fastjson.JSONObject;
import com.dzt.test.entity.BossMapper;
import com.dzt.test.entity.Company;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
public class LoginController extends BaseController{


    private static final String MODEL = "/login";


    @Resource
    public BossMapper bossMapper;



    @RequestMapping("/LoginController")
    @ResponseBody
    public JSONObject login(@RequestParam("name") String name,@RequestParam("password") String password){

        JSONObject jsonObject = new JSONObject();
        System.out.println(name+ " "+password);
        Company company = bossMapper.getCompanyMapper().verify(name, password);
        ArrayList<Company> companyAll = bossMapper.getCompanyMapper().getCompanyAll();
        if (company==null){
            jsonObject.put("key","0");
            jsonObject.put("value","账号密码有误请重新输入");
            return jsonObject;
        }else {
            jsonObject.put("key","1");
            jsonObject.put("company",company);
            jsonObject.put("companyAll",companyAll);
            jsonObject.put("token", service.getLoginService().verify(name,password));
            jsonObject.put("value","登录成功");
        }
        return jsonObject;
    }
}
