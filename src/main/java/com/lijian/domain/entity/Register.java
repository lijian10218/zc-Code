package com.lijian.domain.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Date:2020-12-27
 * @Author:lijian
 **/
public class Register implements Serializable{
    private static final long serialVersionUID = -2923808329074891830L;
    private String registerId;
    private String userId;
    private String buildId;
    private String status;
    private String recommender;
    private Date createTime;
    private Date updateTime;

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBuildId() {
        return buildId;
    }

    public void setBuildId(String buildId) {
        this.buildId = buildId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRecommender() {
        return recommender;
    }

    public void setRecommender(String recommender) {
        this.recommender = recommender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
