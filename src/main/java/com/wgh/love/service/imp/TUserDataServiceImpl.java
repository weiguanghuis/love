package com.wgh.love.service.imp;

import com.wgh.love.mapper.TUserDataMapper;
import com.wgh.love.model.TUserData;
import com.wgh.love.model.TUserDataExample;
import com.wgh.love.service.TUserDataService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
       /* if(username != null && !"".equals(username)){
            username = " and username like '%" + username + "%'";
        }
        List<TUserData> allByOrder = tUserDataMapper.findAllByOrder(username,sortOrder);*/

        TUserDataExample example = new TUserDataExample();
        TUserDataExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(username)){
            criteria.andUsernameLike("%" + username + "%");
        }
        criteria.andStatusEqualTo(1);
        example.setOrderByClause(sortOrder);
        List<TUserData> allByOrder = tUserDataMapper.selectByExample(example);
        return allByOrder;
    }

    /**
     * 添加用户
     * @param userData
     * @return
     */
    @Override
    public int addUser(TUserData userData) {
        return tUserDataMapper.insertSelective(userData);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public int deleteUser(Integer id) {
        TUserDataExample example = new TUserDataExample();
        TUserDataExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        TUserData user = new TUserData();
        user.setStatus(0);
        return tUserDataMapper.updateByExampleSelective(user,example);
    }

    @Override
    public int updateUser(TUserData userData) {
        TUserDataExample example = new TUserDataExample();
        TUserDataExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(userData.getId());
        criteria.andStatusEqualTo(1);
        List<TUserData> selectByExample = tUserDataMapper.selectByExample(example);
        if (selectByExample.size()>0) {
            TUserDataExample example1 = new TUserDataExample();
            TUserDataExample.Criteria criteria1 = example.createCriteria();
            criteria.andIdEqualTo(userData.getId());
            return tUserDataMapper.updateByExampleSelective(userData,example);
        }
        return -1;
    }
}
