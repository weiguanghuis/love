package com.wgh.love.mapper;

import com.wgh.love.model.TUserData;
import com.wgh.love.util.MyMapper;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.provider.ExampleProvider;
import tk.mybatis.mapper.provider.base.BaseInsertProvider;

import java.util.List;

public interface TUserDataMapper extends MyMapper<TUserData> {

    /**
     * 查询普通用户列表
     * @param sortOrder
     * @return
     */
    @Select("select * from t_user_data where 1=1 and status !=0 '#{username}'  order by '#{sortOrder}'")
   // @Select("select * from t_user_data where status=1 ")
    @ResultType(TUserData.class)
    List<TUserData> findAllByOrder(
            @Param("username") String username,
            @Param("sortOrder") String sortOrder);

    /**
     * 添加用户
     * @param userData
     * @return
     */
    @InsertProvider(type = BaseInsertProvider.class,method = "dynamicSQL")
    int insertSelective(TUserData userData);

    /**
     * 根据Example条件进行查询用户
     * @param example
     * @return
     */
    @SelectProvider(type = ExampleProvider.class, method = "dynamicSQL")
    List<TUserData> selectByExample(Object example);

    /**
     * 根据Example条件更新实体`record`包含的不是null的属性值
     * @param record
     * @return
     */
    @UpdateProvider(type = ExampleProvider.class, method = "dynamicSQL")
    int updateByExampleSelective(@Param("record")TUserData record,@Param("example") Object example);
}
