package com.dzt.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import net.sf.json.JSONObject;

public class JWTHelper {
    public static final String tokenKey="dzt_dztXyToKenLogin";

    /**
     * 生成token
     * @param name  用户账号(用户Id)
     * @param password  用户密码(用户电话作为密码)
     * @return
     */
    public static String getToken(String name,String password){
        return JWT.create()
                .withClaim("companyId",name)
                .withClaim("companyPhone",password)
                .withClaim("tokenId",UtilCore.getRanId())
                .sign(Algorithm.HMAC256(tokenKey));
    }

    public static JSONObject resolver(String token){
        //创建JWTVerifier对象用于验证token
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(tokenKey)).build();
        //调用verify方法对token解码 返回解码后的JWT对象
        DecodedJWT verify = verifier.verify(token);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("companyId",verify.getClaim("companyId").asString());
        jsonObject.put("companyPhone",verify.getClaim("companyPhone").asString());
        jsonObject.put("tokenId",verify.getClaim("tokenId").asString());
        return jsonObject;
    }
}
