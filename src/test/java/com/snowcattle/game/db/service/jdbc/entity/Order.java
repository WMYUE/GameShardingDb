package com.snowcattle.game.db.service.jdbc.entity;

import com.snowcattle.game.db.cache.redis.RedisInterface;
import com.snowcattle.game.db.cache.redis.RedisKeyEnum;
import com.snowcattle.game.db.common.annotation.EntitySave;
import com.snowcattle.game.db.common.annotation.FieldSave;
import com.snowcattle.game.db.common.annotation.MethodSaveProxy;
import com.snowcattle.game.db.entity.BaseEntity;

@EntitySave
public class Order extends BaseEntity implements RedisInterface{

    @FieldSave
    private String status;

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    @MethodSaveProxy(proxy="status")
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + getId() +
                ", userId=" + getUserId() +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public String getUniqueKey() {
        return String.valueOf(getId());
    }

    @Override
    public String getRedisKeyEnumString() {
        return "od#";
    }
}