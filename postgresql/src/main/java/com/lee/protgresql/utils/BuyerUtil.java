package com.lee.protgresql.utils;

import com.lee.protgresql.core.entity.Buyer;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author jack
 * @since 2017/12/21
 */
@Component
public class BuyerUtil {

    public List<Buyer> generalBuyer(int count,String nickPre,long mobilePre){
        Buyer buyer;
        List<Buyer> list = new ArrayList<Buyer>();
        int buyerCount;
        double buyerAmount,firstAmount;
        for (int i= 0;i<count;i++){
            buyer = new Buyer();
            buyer.setBuyer_nick(nickPre+"_"+i);
            buyer.setReceiver_mobile(String.valueOf(mobilePre+i));
            buyer.setBuyer_email(String.valueOf(mobilePre+i)+"@163.com");
            buyerCount = randomBuyerCount();
            firstAmount = randomFirstAmount();
            buyerAmount = randomBuyAmount();
            buyer.setBuy_count(buyerCount);
            if (buyerCount==0){
                buyer.setAverage_fee(0d);
                buyer.setFirst_payment(0d);
                buyer.setTotal_fee(0d);
            }else{
                buyer.setAverage_fee((firstAmount+buyerAmount)/buyerCount);
                buyer.setFirst_payment(firstAmount);
                buyer.setTotal_fee(firstAmount+buyerAmount);
            }
            buyer.setBuyer_grade(randomBuyerGrade());
            buyer.setFirst_create_time(randomDate());
            buyer.setFirst_pay_time(randomDate());
            buyer.setLast_create_time(randomDate());
            buyer.setLast_trade_time(randomDate());
            list.add(buyer);
        }
        return list;
    }

    private String formatDate(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

    private Date parseDate(String date){
        Date reDate;
        try
        {
            reDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
        } catch (ParseException e)
        {
            reDate = null;
        }
        return reDate;
    }

    public static Date addDays(Date date, int amount)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, amount);
        return c.getTime();
    }

    public static Date addMonths(Date date, int amount)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, amount);
        return c.getTime();
    }

    public static Date addYear(Date date, int amount)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, amount);
        return c.getTime();
    }


    public static Date addSeconds(Date date, int amount){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.SECOND, amount);
        return c.getTime();
    }

    public static Date addMinutes(Date date, int amount)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, amount);
        return c.getTime();
    }


    public static Date addHours(Date date, int amount)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR_OF_DAY, amount);
        return c.getTime();
    }



    private String randomDate(){
        int year = new Random().nextInt(15);
        int month = new Random().nextInt(12);
        int day = new Random().nextInt(28);
        int hour = new Random().nextInt(24);
        int min = new Random().nextInt(60);
        int sec = new Random().nextInt(60);
        Date date = parseDate((2000+year)+"-"+getDate(month)+"-"+getDate(day)+" "+getDate(hour)+":"+getDate(min)+":"+getDate(sec));
//        Date date = parseDate((2000+year)+"-"+getDate(month)+"-"+getDate(day)+" 00:00:00");
        return formatDate(date);
    }

    private String getDate(int d){
        if (d<10)
            return "0"+d;
        else
            return ""+d;
    }


    private int randomBuyerCount(){
        int max=2000;
        int min=0;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
    }
    private int randomBuyerGrade(){
        Random random = new Random();
        int s = random.nextInt(4);
        return s;
    }

    private Double randomFirstAmount(){
        int max=100;
        int min=0;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return s*1.0;
    }
    private Double randomBuyAmount(){
        int max=2000;
        int min=0;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return s*10.0;
    }

}
