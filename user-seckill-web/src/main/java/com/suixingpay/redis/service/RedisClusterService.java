package com.suixingpay.redis.service;

/**
 * @创建人 胡应山
 * @创建时间 2019/12/7
 * @描述 操作Redis的接口
 */
public interface RedisClusterService {

    /**
     * 向Redis中存储用户（使用zset，可以判断重复）
     * @param id
     * @return
     */
    long saddUser(String activityId, String id);

    /**
     * 获取活动库存(使用get)
     * @param activityId
     * @return
     */
    int getStock(String activityId);

    /**
     * 添加活动时添加开始时间（时间戳）
     * @param activityId
     * @return
     */
    long getBeginTime(String activityId);

    /**
     * 添加活动时添加开始时间（时间戳）
     * @param activityId
     * @return
     */
    long getEndTime(String activityId);

    /**
     * 自减活动库存（使用incr）
     * @param activityId
     * @return
     */
    long decrStock(String activityId);

    /**
     * 添加活动时添加库存
     * @param activityId
     * @param number
     * @return
     */
    String setStock(String activityId, long number);

    /**
     * 添加活动时添加开始时间（时间戳）
     * @param activityId
     * @param begin
     * @return
     */
    String setBeginTime(String activityId, long begin);

    /**
     * 添加活动时添加开始时间（时间戳）
     * @param activityId
     * @param end
     * @return
     */
    String setEndTime(String activityId, long end);

    /**
     * 删除Redis中已经结束的用户
     * @param activityId
     * @return
     */
    long delFinishUser(String activityId);

    /**
     * 删除Redis中已经结束的库存
     * @param activityId
     * @return
     */
    long delFinshStock(String activityId);

    /**
     * 删除Redis中已经结束的开始时间
     * @param activityId
     * @return
     */
    long delBeginTime(String activityId);

    /**
     * 删除Redis中已经结束的结束时间
     * @param activityId
     * @return
     */
    long delFinshTime(String activityId);

}
