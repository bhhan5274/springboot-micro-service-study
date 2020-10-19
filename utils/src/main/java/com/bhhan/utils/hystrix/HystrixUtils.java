package com.bhhan.utils.hystrix;

import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;

/**
 * Created by hbh5274@gmail.com on 2020-10-19
 * Github : http://github.com/bhhan5274
 */
public class HystrixUtils {

    public static HystrixThreadLocalConfiguration hystrixThreadLocalConfiguration(HystrixConcurrencyStrategy existingConcurrencyStrategy){
        return new HystrixThreadLocalConfiguration(existingConcurrencyStrategy);
    }
}
