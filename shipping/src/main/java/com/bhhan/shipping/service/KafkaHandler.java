package com.bhhan.shipping.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Created by hbh5274@gmail.com on 2020-10-20
 * Github : http://github.com/bhhan5274
 */

@Slf4j
@EnableBinding(Sink.class)
public class KafkaHandler {
    @StreamListener(Sink.INPUT)
    public void loggerSink(OrderCompletedModel orderCompletedModel){
        log.info("Received an event for order id {} at {}", orderCompletedModel.getId(), orderCompletedModel.getDeliveredAt());
    }
}
