package com.sign.test;/**
 * Created by dell on 2017/11/6.
 */

import com.sign.HmacSha256Util;
import com.sign.Md5Util;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * md5摘要测试
 *
 * @author jiasx
 * @create 2017-11-06 10:41
 **/
public class SignTest {

    @Test
    public void testMd5() {
        String kerSecret = Md5Util.generateKeySecret();
        String digest = Md5Util.generateMd5("admin",kerSecret);
        System.out.println(kerSecret+"==========="+digest+"========"+Md5Util.verify("admin", digest,kerSecret));
    }

    @Test
    public void testHmac256() {
        String key = "andy123456";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("params2","gril");
        paramMap.put("username","admin");
        paramMap.put("params1","love");
        //在服务器端生成客户端参数消息摘要
        String serverDigest = HmacSha256Util.digest(key, paramMap);
        System.out.println(serverDigest);
        Map<String, String> remap = HmacSha256Util.sortMapByKey(paramMap);
        for(Map.Entry<String,String> entry:remap.entrySet()){
            System.out.println(entry.getKey()+"========="+entry.getValue());
        }

    }



}
