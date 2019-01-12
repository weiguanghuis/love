package com.wgh.love.mapper;

import com.wgh.love.model.TUserData;
import com.wgh.love.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TUserDataMapper extends MyMapper<TUserData> {

    /**
     * 查询普通用户列表
     * @param id
     * @return
     */
    @Select("select * from t_user_data where 1=1 and status !=0 order by id")
    @ResultType(TUserData.class)
    List<TUserData> findAllByOrder(@Param("id") Integer id);
}