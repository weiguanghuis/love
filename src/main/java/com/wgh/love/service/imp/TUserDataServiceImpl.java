package com.wgh.love.service.imp;

import com.wgh.love.mapper.TUserDataMapper;
import com.wgh.love.model.TUserData;
import com.wgh.love.service.TUserDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**用户管理接口实现
 * 作者: zzl
 * 创建于: 2019/1/12 15:19
 */
@Service
public class TUserDataServiceImpl implements TUserDataService {

    @Resource
    private TUserDataMapper tUserDataMapper;

    /**
     * 查询普通用户列表
     * @param username
     * @return
     */
    @Override
    public List<TUserData> queryAllTUserData(String username,String sortOrder) {
        if(username != null && !"".equals(username)){
            username = " and username like '%" + username + "%'";
        }
        List<TUserData> allByOrder = tUserDataMapper.findAllByOrder(username,sortOrder);
        return allByOrder;
    }
}
