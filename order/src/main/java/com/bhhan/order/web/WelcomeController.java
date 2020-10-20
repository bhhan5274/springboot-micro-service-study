package com.bhhan.order.web;

import com.bhhan.order.service.ShippingRestTemplateClient;
import com.bhhan.order.service.SimpleSourceBean;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created by hbh5274@gmail.com on 2020-10-15
 * Github : http://github.com/bhhan5274
 */

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class WelcomeController {
    private final ShippingRestTemplateClient restTemplateClient;
    private final SimpleSourceBean simpleSourceBean;

    @GetMapping
    public String welcome(){
        return "I'm Order -> " + restTemplateClient.getWelcomeMessage();
    }

    @GetMapping("kafka/{orderId}")
    public String kafkaStream(@PathVariable Long orderId){
        simpleSourceBean.publishOrderCompleted(LocalDateTime.now(), orderId);
        return "publish completed";
    }

    @GetMapping("jenkins")
    public String jenkinsHello(){
        return "Jenkins Hello World!!!";
    }
}
