package com.delvo.commerce;

public class RewardModel {
    private String title;
    private String expairyDate;
    private String couponBody;

    public RewardModel(String title, String expairyDate, String couponBody) {
        this.title = title;
        this.expairyDate = expairyDate;
        this.couponBody = couponBody;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpairyDate() {
        return expairyDate;
    }

    public void setExpairyDate(String expairyDate) {
        this.expairyDate = expairyDate;
    }

    public String getCouponBody() {
        return couponBody;
    }

    public void setCouponBody(String couponBody) {
        this.couponBody = couponBody;
    }
}
