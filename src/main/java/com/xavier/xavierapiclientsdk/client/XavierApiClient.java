package com.xavier.xavierapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.xavier.xavierapiclientsdk.model.LoveSentence;
import com.xavier.xavierapiclientsdk.model.User;
import com.xavier.xavierapiclientsdk.util.SignUtil;

import java.util.HashMap;
import java.util.Map;

/**
 *  调用第三方接口的客户端
 */
public class XavierApiClient {

    private static final String GATEWAY_HOST = "http://106.15.95.36:8090";

    private String accessKey;

    private String secretKey;

    public XavierApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name) {
        //可以单独传入http参数，这样参数会自动坐url编码，拼接在url
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.get(GATEWAY_HOST + "/api/name/", paramMap);
        return result;
    }

    public String getNameByPost(String name){
        //可以单独传入http参数，这样参数会自动坐url编码，拼接在url
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.post(GATEWAY_HOST + "/api/name/", paramMap);
        return result;
    }

    public String getUserNameByPost(User user){
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/user")
                .addHeaders(getHeaders(json))
                .body(json)
                .execute();
        System.out.println("状态码：" + httpResponse.getStatus());
        String result = httpResponse.body();
        return result;
    }

    /**
     * 调用表白情话接口
     * @param loveSentence
     * @return
     */
    public String getRandomLoveSentenceByPost(LoveSentence loveSentence){
        String json = JSONUtil.toJsonStr(loveSentence);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/love/loveSentence")
                .addHeaders(getHeaders(json))
                .body(json)
                .execute();
        return httpResponse.body();
    }

    public Map<String, String> getHeaders(String body){
        HashMap<String, String> headers = new HashMap<>();
        headers.put("accessKey", accessKey);
        headers.put("nonce", RandomUtil.randomNumbers(4));
        headers.put("body",body);
        headers.put("timestamp", String.valueOf(System.currentTimeMillis()/1000));
        headers.put("sign", SignUtil.getSign(body, secretKey));
        return headers;
    }

}
