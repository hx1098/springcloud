package com.mashibing.eurekaserver;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

/**
 * @author hx
 * @createTime 2020/12/19 22:59
 * @option  实现HealthIndicator,实现
 * @description
 */
@Service
public class HealthStatusService implements HealthIndicator {
    private Boolean status = true;

    public void setStatus(Boolean status) {
        this.status  = status;
    }

    @Override
    public Health health() {
        // TODO Auto-generated method stub
        if(status)
            return new Health.Builder().up().build();
        return new Health.Builder().down().build();
    }

    public String getStatus() {
        // TODO Auto-generated method stub
        return this.status.toString();
    }
}
