package com.bhhan.shipping.web;

import com.bhhan.shipping.config.CustomProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by hbh5274@gmail.com on 2020-10-16
 * Github : http://github.com/bhhan5274
 */

@RestController
@RequestMapping("/v1/shippings")
@RequiredArgsConstructor
public class WelcomeController {
    private final CustomProperties customProperties;

    @GetMapping
    public String welcome(){
        randomlyRunLong();
        return customProperties.getUsername();
    }

    private void randomlyRunLong(){
        Random random = new Random();
        int randomNum = random.nextInt((3 - 1) + 1) + 1;
        if(randomNum == 3) {
            sleep();
        }
    }

    private void sleep(){
        try{
            Thread.sleep(5000L);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
