package com.example.demoserver.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class HttpTools {

    private RestTemplate restTemplate;

    public RestTemplate getRestTemplate() {
        if (this.restTemplate == null) {
            this.restTemplate = new RestTemplate();
        }
        return restTemplate;
    }

    public String doGet(String url, Map<String, Object> param) {
        HttpHeaders headers = new HttpHeaders();
        JSONObject json = (JSONObject) JSONObject.toJSON(param);
        HttpEntity<JSONObject> entity = new HttpEntity<>(json, headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
    }

}
