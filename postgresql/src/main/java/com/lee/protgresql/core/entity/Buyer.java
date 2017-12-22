package com.lee.protgresql.core.entity;

/**
 * @author jack
 * @since 2017/12/21
 */
public class Buyer {

    private String buyer_nick;

    private String receiver_mobile;

    private String buyer_email;

    private Double average_fee;

    private Double first_payment;

    private Integer buyer_grade;

    private Integer buy_count;

    private Double total_fee;

    private String first_pay_time;

    private String last_trade_time;

    private String first_create_time;

    private String last_create_time;

    public String getBuyer_nick() {
        return buyer_nick;
    }

    public void setBuyer_nick(String buyer_nick) {
        this.buyer_nick = buyer_nick;
    }

    public String getReceiver_mobile() {
        return receiver_mobile;
    }

    public void setReceiver_mobile(String receiver_mobile) {
        this.receiver_mobile = receiver_mobile;
    }

    public String getBuyer_email() {
        return buyer_email;
    }

    public void setBuyer_email(String buyer_email) {
        this.buyer_email = buyer_email;
    }

    public Double getAverage_fee() {
        return average_fee;
    }

    public void setAverage_fee(Double average_fee) {
        this.average_fee = average_fee;
    }

    public Double getFirst_payment() {
        return first_payment;
    }

    public void setFirst_payment(Double first_payment) {
        this.first_payment = first_payment;
    }

    public Integer getBuyer_grade() {
        return buyer_grade;
    }

    public void setBuyer_grade(Integer buyer_grade) {
        this.buyer_grade = buyer_grade;
    }

    public Integer getBuy_count() {
        return buy_count;
    }

    public void setBuy_count(Integer buy_count) {
        this.buy_count = buy_count;
    }

    public Double getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Double total_fee) {
        this.total_fee = total_fee;
    }

    public String getFirst_pay_time() {
        return first_pay_time;
    }

    public void setFirst_pay_time(String first_pay_time) {
        this.first_pay_time = first_pay_time;
    }

    public String getLast_trade_time() {
        return last_trade_time;
    }

    public void setLast_trade_time(String last_trade_time) {
        this.last_trade_time = last_trade_time;
    }

    public String getFirst_create_time() {
        return first_create_time;
    }

    public void setFirst_create_time(String first_create_time) {
        this.first_create_time = first_create_time;
    }

    public String getLast_create_time() {
        return last_create_time;
    }

    public void setLast_create_time(String last_create_time) {
        this.last_create_time = last_create_time;
    }
}
