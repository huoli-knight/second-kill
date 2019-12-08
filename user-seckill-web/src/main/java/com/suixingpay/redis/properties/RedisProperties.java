package com.suixingpay.redis.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @创建人 胡应山
 * @创建时间 2019/12/7
 * @描述 读取Redis集群信息
 */
@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
@Data
public class RedisProperties {
    private String nodes;
}
