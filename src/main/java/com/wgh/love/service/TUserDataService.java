package com.wgh.love.service;

import com.wgh.love.model.TUserData;

import java.util.List;

/**
 * 用户管理接口
 *
 * 作者: zzl
 * 创建于: 2019/1/12 15:18
 */
public interface TUserDataService {

    /**
     * 查询普通用户列表
     * @param username
     * @return
     */
    public List<TUserData> queryAllTUserData(String username,String sortOrder);

    /**
     * 添加用户
     * @param userData
     * @return
     */
    public int addUser(TUserData userData);

    /**根据id
     * 删除用户
     * @param id
     * @return
     */
    public int deleteUser(Integer id);

    /**
     * 根据id修改用户信息
     * @param userData
     * @return
     */
    public int updateUser(TUserData userData);
}
