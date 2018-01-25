package com.lee.protgresql.core.service;

import com.lee.protgresql.core.dao.BuyerDao;
import com.lee.protgresql.core.entity.Buyer;
import com.lee.protgresql.utils.BuyerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author jack
 * @since 2017/12/21
 */
@Service
public class BuyerService {

    @Autowired
    BuyerDao buyerDao;

    @Autowired
    BuyerUtil buyerUtil;

    public Map<String,Object> getBuyerByNick(String buyerNick){
        return buyerDao.getBuyerByNick(buyerNick);
    }

    public boolean saveBuyer(){
       String nickPre = "jack";
        long mobilePre = 13000000000L;
        boolean flag = false;
        for(int i = 1;i<50;i++){
            List<Buyer> list = buyerUtil.generalBuyer(100000, ""+(i+1)+nickPre+""+i, mobilePre+100000*i);
            flag = buyerDao.saveBuyer(list);
        }

        return flag;
    }
}
