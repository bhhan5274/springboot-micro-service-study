package com.bhhan.utils.consul;

import com.bhhan.utils.consul.dto.ConsulDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotEmpty;

/**
 * Created by hbh5274@gmail.com on 2020-10-26
 * Github : http://github.com/bhhan5274
 */

@Configuration
@ConfigurationProperties(prefix = "consul")
@Getter
@Setter
public class ConsulProperties {
    private static final String API = "/v1/agent/service/";

    @NotEmpty
    private String url;

    @NotEmpty
    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    @NotEmpty
    private int port;

    @NotEmpty
    private String checkHealthName;

    @NotEmpty
    private String checkHealthInterval;

    @NotEmpty
    private String checkHealthHttp;

    public String getRegisterUrl(){
        return makeUrl("register");
    }

    public String getUnRegisterUrl(){
        return makeUrl("deregister");
    }

    private String makeUrl(String action) {
        return String.format("%s%s%s", url, API, action);
    }
}
