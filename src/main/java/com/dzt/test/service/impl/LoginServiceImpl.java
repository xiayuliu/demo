package com.dzt.test.service.impl;

import com.dzt.redis.RedisKeyConstant;
import com.dzt.test.entity.BossMapper;
import com.dzt.test.service.LoginService;
import com.dzt.token.JwtTokenUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    public BossMapper bossMapper;

    @Resource
    public StringRedisTemplate stringRedisTemplate;

    @Value("${jwt.expire}")
    public int expire;

    /**
     * 生成token 放入redis
     * @param name 账号
     * @param password  密码
     * @return token
     */
    @Override
    public String verify(String name, String password) {
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String token = jwtTokenUtil.getConsoleToken(name, password);
        JSONObject resolver = jwtTokenUtil.resolver(token);//解析token
        resolver.put("token",token);

        String tokenId = (String) resolver.get("tokenId");
        stringRedisTemplate.opsForValue().set(RedisKeyConstant.REDIS_KEY_TOKEN+tokenId,resolver.toString(),expire, TimeUnit.SECONDS);

        return token;
    }
}
