package com.bhhan.utils.consul.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hbh5274@gmail.com on 2020-10-26
 * Github : http://github.com/bhhan5274
 */
public class ConsulDto {

    @Getter
    @Setter
    public static class ReqData {
        private String id;
        private String name;
        private String address;
        private int port;
        private CheckHealth check;

        @Builder
        public ReqData(String id, String name, String address, int port, CheckHealth check){
            this.id = id;
            this.name = name;
            this.address = address;
            this.port = port;
            this.check = check;
        }
    }

    @Getter
    @Setter
    public static class CheckHealth {
        private String name;
        private String interval;
        private String http;

        @Builder
        public CheckHealth(String name, String interval, String http){
            this.name = name;
            this.interval = interval;
            this.http = http;
        }
    }
}
