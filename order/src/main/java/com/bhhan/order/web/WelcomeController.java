package com.bhhan.order.web;

import com.bhhan.order.service.ShippingRestTemplateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hbh5274@gmail.com on 2020-10-15
 * Github : http://github.com/bhhan5274
 */

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class WelcomeController {
    private final ShippingRestTemplateClient restTemplateClient;

    @GetMapping
    public String welcome(){
        return "I'm Order -> " + restTemplateClient.getWelcomeMessage();
    }
}
