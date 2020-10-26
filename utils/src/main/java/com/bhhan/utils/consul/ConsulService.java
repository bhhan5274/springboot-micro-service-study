package com.bhhan.utils.consul;

import com.bhhan.utils.consul.dto.ConsulDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hbh5274@gmail.com on 2020-10-26
 * Github : http://github.com/bhhan5274
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsulService {
    private final ConsulProperties consulProperties;

    public void registerService(ConsulDto.ReqData consulReqData){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ConsulDto.ReqData> entity = new HttpEntity<>(consulReqData, headers);

        ResponseEntity<String> response = restTemplate.exchange(consulProperties.getRegisterUrl(),
                HttpMethod.PUT,
                entity,
                String.class);
        if(response.getStatusCode() == HttpStatus.OK){
            log.info("[register consul {} > {} application, {} ID]", consulProperties.getRegisterUrl(), consulReqData.getName(), consulReqData.getId());
        }
    }

    public void deregisterService(String serviceId){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(consulProperties.getUnRegisterUrl(),
                HttpMethod.PUT,
                null,
                String.class);
        if(response.getStatusCode() == HttpStatus.OK){
            log.info("[register consul {} > {} ID]", consulProperties.getRegisterUrl(), serviceId);
        }
    }
}
