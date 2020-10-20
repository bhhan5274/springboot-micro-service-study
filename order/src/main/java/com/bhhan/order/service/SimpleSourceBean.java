package com.bhhan.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by hbh5274@gmail.com on 2020-10-20
 * Github : http://github.com/bhhan5274
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class SimpleSourceBean {
    private final Source source;

    public void publishOrderCompleted(LocalDateTime now, Long orderId){
        log.info("Sending kafka LocalDateTime {} for Order Id: {}", now, orderId);
        OrderCompletedModel orderCompletedModel = OrderCompletedModel.builder()
                .id(orderId)
                .deliveredAt(now)
                .build();

        source.output()
                .send(MessageBuilder.withPayload(orderCompletedModel).build());
    }
}
