package com.bhhan.shipping.config;

import com.bhhan.utils.CustomRestTemplateUtils;
import com.bhhan.utils.hystrix.HystrixThreadLocalConfiguration;
import com.bhhan.utils.hystrix.HystrixUtils;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.servlet.Filter;

/**
 * Created by hbh5274@gmail.com on 2020-10-19
 * Github : http://github.com/bhhan5274
 */

@Configuration
public class Utils {
    @Autowired(required = false)
    HystrixConcurrencyStrategy hystrixConcurrencyStrategy;


    @LoadBalanced
    @Bean
    public RestTemplate customRestTemplate(){
        return CustomRestTemplateUtils.customRestTemplate();
    }

    @Bean
    public HystrixThreadLocalConfiguration hystrixThreadLocalConfiguration(){
        return HystrixUtils.hystrixThreadLocalConfiguration(hystrixConcurrencyStrategy);
    }

    @Bean
    public Filter customFilter(){
        return CustomRestTemplateUtils.customFilter();
    }
}
