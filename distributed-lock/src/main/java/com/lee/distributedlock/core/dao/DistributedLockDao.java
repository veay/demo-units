package com.lee.distributedlock.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 * @since 2017/12/15
 */
@Repository
public class DistributedLockDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public long getId(){
        String sql = "select id from distributed_lock where status = 0 limit 1 ";
        try{
            long id = jdbcTemplate.queryForObject(sql,Long.class);
            return id;
        }catch (Exception e){
            if (e instanceof EmptyResultDataAccessException){

            }else{
                e.printStackTrace();
            }
        }
       return 0;
    }


    public boolean updateId(long id){
        String sql = "update  distributed_lock set status = 1 where status = 0  and id = ? ";
        int count = jdbcTemplate.update(sql,id);
        return count>0;
    }

    public boolean initData(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<100;i++){
            list.add(i);
        }
        String sql = "insert into  distributed_lock(data) values(?) ";
        int [] result = jdbcTemplate.batchUpdate(sql,new BatchPreparedStatementSetter(){
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1,list.get(i));
            }
            @Override
            public int getBatchSize() {
                return list.size();
            }
        });
        return result!=null && result.length>0;
    }
}
