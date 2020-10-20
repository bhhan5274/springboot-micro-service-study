package com.bhhan.order.service;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Created by hbh5274@gmail.com on 2020-10-20
 * Github : http://github.com/bhhan5274
 */

@Getter
@Setter
public class OrderCompletedModel {
    private LocalDateTime deliveredAt;
    private Long id;

    @Builder
    public OrderCompletedModel(LocalDateTime deliveredAt, Long id){
        this.deliveredAt = deliveredAt;
        this.id = id;
    }
}
