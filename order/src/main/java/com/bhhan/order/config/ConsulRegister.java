package com.bhhan.order.config;

import com.bhhan.utils.consul.ConsulProperties;
import com.bhhan.utils.consul.ConsulService;
import com.bhhan.utils.consul.dto.ConsulDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by hbh5274@gmail.com on 2020-10-26
 * Github : http://github.com/bhhan5274
 */

@Component
@RequiredArgsConstructor
public class ConsulRegister implements ApplicationRunner {
    private final ConsulService consulService;
    private final ConsulProperties consulProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        consulService.deregisterService(consulProperties.getId());
        consulService.registerService(ConsulDto.ReqData
        .builder()
        .id(consulProperties.getId())
        .name(consulProperties.getName())
        .port(consulProperties.getPort())
        .address(consulProperties.getAddress())
        .check(ConsulDto.CheckHealth.builder()
                .name(consulProperties.getCheckHealthName())
                .interval(consulProperties.getCheckHealthInterval())
                .http(consulProperties.getCheckHealthHttp())
                .build())
        .build());
    }
}
