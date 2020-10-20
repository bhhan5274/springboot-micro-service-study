package com.bhhan.shipping;

import com.bhhan.shipping.config.CustomProperties;
import com.bhhan.shipping.config.OAuth2Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by hbh5274@gmail.com on 2020-10-16
 * Github : http://github.com/bhhan5274
 */

@EnableResourceServer
@EnableEurekaClient
@SpringBootApplication
@EnableConfigurationProperties({CustomProperties.class, OAuth2Properties.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
