package com.lee.protgresql.core.dao;

import com.lee.protgresql.base.DBControl;
import com.lee.protgresql.core.entity.Buyer;
import org.apache.commons.dbutils.DbUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jack
 * @since 2017/12/21
 */
@Repository
public class BuyerDao {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    DBControl dbControl;

    public Map<String,Object> getBuyerByNick(String buyerNick){
        Map<String,Object> map = new HashMap<String,Object>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = dbControl.getConnection();
            String sql = "select * from dk_buyer_56 where buyer_nick = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,buyerNick);
            rs = ps.executeQuery();
            while (rs.next()){
                map.put("buyer_nick",rs.getString("buyer_nick"));
                map.put("receiver_mobile",rs.getString("receiver_mobile"));
                map.put("buyer_email",rs.getString("buyer_email"));
                map.put("buy_count",rs.getString("buy_count"));
                map.put("total_fee",rs.getString("total_fee"));
            }
        }catch (Exception e){
            logger.error("",e);
        }finally {
            DbUtils.closeQuietly(conn,ps,rs);
        }
        return map;
    }

    public boolean saveBuyer(List<Buyer> list){
        long start = System.currentTimeMillis();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = dbControl.getConnection();
            String sql = "insert into dk_buyer_56(buyer_nick,receiver_mobile,buyer_email,average_fee,first_payment,buyer_grade,buy_count,total_fee,first_create_time,first_pay_time,last_create_time,last_trade_time)" +
                    " values(?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            int i = 0;
            Integer index;
            for (Buyer buyer:list){
                index = 0;
                ps.setString(++index,buyer.getBuyer_nick());
                ps.setString(++index,buyer.getReceiver_mobile());
                ps.setString(++index,buyer.getBuyer_email());
                ps.setDouble(++index,buyer.getAverage_fee());
                ps.setDouble(++index,buyer.getFirst_payment());
                ps.setInt(++index,buyer.getBuyer_grade());
                ps.setInt(++index,buyer.getBuy_count());
                ps.setDouble(++index,buyer.getTotal_fee());
                ps.setTimestamp(++index,toTimestamp(buyer.getFirst_create_time()));
                ps.setTimestamp(++index,toTimestamp(buyer.getFirst_pay_time()));
                ps.setTimestamp(++index,toTimestamp(buyer.getLast_create_time()));
                ps.setTimestamp(++index,toTimestamp(buyer.getLast_trade_time()));
                i++;
                if (i%10000==0){
                    ps.executeBatch();
                    i=0;
                }else{
                    ps.addBatch();
                }
            }
            if (i>0){
                ps.executeBatch();
            }
        }catch (Exception e){
            logger.error("",e);
            return false;
        }finally {
            long stop = System.currentTimeMillis();
            logger.info(""+list.size()+","+(stop-start)/1000);
            DbUtils.closeQuietly(conn,ps,rs);
        }
        return true;
    }

    /**
     * 把字符串日期转换为时间戳Timestamp
     * @param dateTime
     * @return Timestamp
     * @author sam
     * @since 2017年12月21日
     */
    private Timestamp toTimestamp(String dateTime){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = 0;
        try{
            time = formatter.parse(dateTime).getTime();
        }catch(Exception e){
            logger.error("toTimestamp函数出现异常：",e);
            return null;
        }
        return new Timestamp(time);
    }

}
