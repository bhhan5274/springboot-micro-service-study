package com.bhhan.oauth2svr;

import com.bhhan.oauth2svr.config.OAuth2Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hbh5274@gmail.com on 2020-10-19
 * Github : http://github.com/bhhan5274
 */

@SpringBootApplication
@RestController
@EnableConfigurationProperties(OAuth2Properties.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!!!";
    }
}
