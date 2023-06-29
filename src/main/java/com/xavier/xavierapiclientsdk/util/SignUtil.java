package com.xavier.xavierapiclientsdk.util;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * 签名工具
 */
public class SignUtil {

    /**
     * 生成签名
     * @param body
     * @param secretKey
     * @return
     */
    public static String getSign(String body, String secretKey){
        String content = body + "." + secretKey;
        Digester digester = new Digester(DigestAlgorithm.SHA256);
        return digester.digestHex(content);
    }

}
