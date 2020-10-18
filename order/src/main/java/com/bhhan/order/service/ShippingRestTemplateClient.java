package com.bhhan.order.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hbh5274@gmail.com on 2020-10-16
 * Github : http://github.com/bhhan5274
 */

@Component
@RequiredArgsConstructor
@DefaultProperties(threadPoolKey = "shippingRestTemplateClient")
public class ShippingRestTemplateClient {
    private final RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackGetWelcomeMessage")
    public String getWelcomeMessage(){
        ResponseEntity<String> restExchange = restTemplate.getForEntity("http://shipping/v1/shippings",
                String.class);

        return restExchange.getBody();
    }

    private String fallbackGetWelcomeMessage(){
        return "Hello World!!!";
    }
}
