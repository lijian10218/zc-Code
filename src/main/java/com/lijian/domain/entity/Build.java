package com.lijian.domain.entity;

import java.math.BigDecimal;

/**
 * @Description
 * @Date:2020-12-27
 * @Author:lijian
 **/
public class Build {
    private String buildId;
    private String buildName;
    private String buildAddr;
    private String buildIntroduce;
    private String buildImg;
    private BigDecimal buildPrice;

    public String getBuildId() {
        return buildId;
    }

    public void setBuildId(String buildId) {
        this.buildId = buildId;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getBuildAddr() {
        return buildAddr;
    }

    public void setBuildAddr(String buildAddr) {
        this.buildAddr = buildAddr;
    }

    public String getBuildIntroduce() {
        return buildIntroduce;
    }

    public void setBuildIntroduce(String buildIntroduce) {
        this.buildIntroduce = buildIntroduce;
    }

    public String getBuildImg() {
        return buildImg;
    }

    public void setBuildImg(String buildImg) {
        this.buildImg = buildImg;
    }

    public BigDecimal getBuildPrice() {
        return buildPrice;
    }

    public void setBuildPrice(BigDecimal buildPrice) {
        this.buildPrice = buildPrice;
    }
}
