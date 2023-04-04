package com.dzt.token;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UtilCore {

    //获取当前时间
    public static String getNewDate(String format){
        Date data = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return  simpleDateFormat.format(data);
    }



    //生成随机数
    public static String getRandom(int i){
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {

        }
        Random random = new Random();
        if (i==0) return "";
        String ran="";
        for (int j=0;j<i;j++){
            ran+=random.nextInt(9);
        }
        return ran;
    }

    public static String getRanId(){
        return getNo(6);
    }

    //用于生成token
    public static String getNo(int i) {
        return getNewDate("yyyyMMddssSSS")+getRandom(i);
    }
}
