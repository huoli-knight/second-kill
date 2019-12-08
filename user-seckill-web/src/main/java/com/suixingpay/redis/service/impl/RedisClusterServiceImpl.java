package com.suixingpay.redis.service.impl;

import com.suixingpay.redis.service.RedisClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

/**
 * @创建人 胡应山
 * @创建时间 2019/12/7
 * @描述 操作Redis的接口实现
 */
@Service
public class RedisClusterServiceImpl implements RedisClusterService {

    @Autowired
    private JedisCluster jedis;

    @Value("${USER_NAME}")
    private String user;

    @Value("${MAIN_FOLDER}")
    private String main;

    @Value("${BEGIN_TIME}")
    private String begin;

    @Value("${END_TIME}")
    private String end;

    @Value("${USER_STOCK}")
    private String stock;

    /**
     * 添加鑫联盟抢购成功的用户到redis中[使用zset进行存储]
     * 如果存在则返回0， 不存在返回1【防止用户重复提交】
     * @param activityId 活动的标识（唯一）
     * @param id 用户的ID
     * @return
     */
    @Override
    public long saddUser(String activityId, String id) {

        String name = main + ":" + activityId + ":" + user;
        return jedis.sadd(name, id);

    }

    /**
     * 获取活动的库存
     * @param activityId 活动的标识（唯一）
     * @return
     */
    @Override
    public int getStock(String activityId) {

        String name = main + ":" + activityId + ":" + stock;
        return Integer.parseInt(jedis.get(name));

    }

    /**
     * 获取活动开始时间
     * @param activityId
     * @return
     */
    @Override
    public long getBeginTime(String activityId) {

        String name = main + ":" + activityId + ":" + begin;
        return Long.parseLong(jedis.get(name));

    }

    /**
     * 获取活动结束时间
     * @param activityId
     * @return
     */
    @Override
    public long getEndTime(String activityId) {

        String name = main + ":" + activityId + ":" + end;
        return Long.parseLong(jedis.get(name));

    }


    /**
     * 当用户抢到后，进行减1操作
     * @param activityId 活动的标识（唯一）
     * @return
     */
    @Override
    public long decrStock(String activityId) {

        String name = main + ":" + activityId + ":" + stock;
        return jedis.decr(name);

    }

    /**
     * 设置库存
     * @param activityId 活动的标识（唯一）
     * @param number 活动的人数
     * @return
     */
    @Override
    public String setStock(String activityId, long number) {

        String name = main + ":" + activityId + ":" + stock;
        return jedis.set(name, number+"");

    }

    /**
     * 设置开始时间（需要时间戳）
     * @param activityId 活动的标识（唯一）
     * @param begin 开始时间
     * @return
     */
    @Override
    public String setBeginTime(String activityId, long begin) {

        String name = main + ":" + activityId + ":" + begin;
        return jedis.set(name, begin+"");

    }

    /**
     * 设置结束时间（需要时间戳）
     * @param activityId 活动的标识（唯一）
     * @param end 结束时间
     * @return
     */
    @Override
    public String setEndTime(String activityId, long end) {

        String name = main + ":" + activityId + ":" + end;
        return jedis.set(name, end+"");

    }

    /**
     * 删除所有用户
     * @param activityId 活动的标识（唯一）
     * @return
     */
    @Override
    public long delFinishUser(String activityId) {

        String name = main + ":" + activityId + ":" + user;
        return jedis.del(name);

    }

    /**
     * 删除库存
     * @param activityId 活动的标识（唯一）
     * @return
     */
    @Override
    public long delFinshStock(String activityId) {

        String name = main + ":" + activityId + ":" + stock;
        return jedis.del(name);

    }

    /**
     * 删除开始时间
     * @param activityId 活动的标识（唯一）
     * @return
     */
    @Override
    public long delBeginTime(String activityId) {

        String name = main + ":" + activityId + ":" + begin;
        return jedis.del(name);

    }

    /**
     * 删除结束时间
     * @param activityId 活动的标识（唯一）
     * @return
     */
    @Override
    public long delFinshTime(String activityId) {

        String name = main + ":" + activityId + ":" + end;
        return jedis.del(name);

    }
}
