package com.bhhan.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import javax.servlet.Filter;
import java.io.IOException;
import java.util.List;

/**
 * Created by hbh5274@gmail.com on 2020-10-19
 * Github : http://github.com/bhhan5274
 */

@Configuration
@Slf4j
public class CustomRestTemplateUtils {
    public static RestTemplate customRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        interceptors.add(new CustomRequestInterceptor());
        restTemplate.setInterceptors(interceptors);

        return restTemplate;
    }

    public static Filter customFilter(){
        return new UserContextFilter();
    }

    static class CustomRequestInterceptor implements ClientHttpRequestInterceptor {
        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            HttpHeaders headers = request.getHeaders();
            headers.add(UserContext.AUTH_TOKEN, UserContextHolder.getContext().getAuthToken());

            return execution.execute(request, body);
        }
    }
}
