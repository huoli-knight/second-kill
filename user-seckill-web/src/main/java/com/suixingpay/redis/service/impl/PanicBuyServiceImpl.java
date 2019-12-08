package com.suixingpay.redis.service.impl;

import com.suixingpay.rabbitmq.utils.MQSender;
import com.suixingpay.redis.exception.GlobalException;
import com.suixingpay.redis.service.PanicBuyService;
import com.suixingpay.redis.service.RedisClusterService;
import com.suixingpay.redis.utils.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @创建人 胡应山
 * @创建时间 2019/12/7
 * @描述 抢购业务模块接口实现
 */
@Service
@Slf4j
public class PanicBuyServiceImpl implements PanicBuyService {

    @Autowired
    private RedisClusterService redisClusterService;

    @Autowired(required=true)
    private MQSender mqSender;

    //$$$$$$$$$$测试使用$$$$$$$$$$
    private static final String ACTIVITY = "test";

    @Override
    public boolean userEnterRedis() {
        try {
            //活动未开始
            if (System.currentTimeMillis() < redisClusterService.getBeginTime(ACTIVITY)) {
                log.error("活动还未到开启时间！");
                throw new GlobalException("活动还未到开启时间！" ,ResultCode.NOT_START.getCode());
            }
            //活动已结束
            if (System.currentTimeMillis() > redisClusterService.getEndTime(ACTIVITY)) {
                log.error("抱歉，本场活动已结束！");
                throw new GlobalException("抱歉，本场活动已结束！" ,ResultCode.OUT_OF_TIME.getCode());
            }
            //$$$$$$$$$$模拟用户的ID$$$$$$$$$$
            String id = UUID.randomUUID().toString().replaceAll("-", "");
            long result = redisClusterService.saddUser(ACTIVITY, id);
            //重复抢购
            if (result<=0) {
                log.error("你已成功参加本次活动！");
                throw new GlobalException("你已成功参加本次活动！" ,ResultCode.RESUBMIT.getCode());
            }
            //库存不足
            if(redisClusterService.decrStock(ACTIVITY) < 0){
                log.error("抱歉！本次用户数已经抢完，请留意下次活动");
                throw new GlobalException("抱歉！本次用户数已经抢完，请留意下次活动" ,ResultCode.RESUBMIT.getCode());
            }
            redisClusterService.saddUser(ACTIVITY, id);
            log.info("成功");
            mqSender.sendRequest(id);
            return true;
        } finally {

        }

    }
}
