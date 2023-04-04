package com.dzt.token;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {

    @Value("${jwt.expire}")
    private int expire;

    public String getConsoleToken(String logname,String companyId){
        return JWTHelper.getToken(logname,companyId);
    }

    public JSONObject resolver(String token){
        return  JWTHelper.resolver(token);
    }


}
