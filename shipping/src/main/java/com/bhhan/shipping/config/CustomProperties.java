package com.bhhan.shipping.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * Created by hbh5274@gmail.com on 2020-10-15
 * Github : http://github.com/bhhan5274
 */

@ConfigurationProperties("bhhan")
@Getter
@Setter
@Validated
public class CustomProperties {
    @NotBlank
    private String username;
}
