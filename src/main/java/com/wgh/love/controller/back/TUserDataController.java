package com.wgh.love.controller.back;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wgh.love.controller.BaseController;
import com.wgh.love.model.LayDates;
import com.wgh.love.model.LaytableDate;
import com.wgh.love.model.TUserData;
import com.wgh.love.service.TUserDataService;
import com.wgh.love.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 后台-用户管理
 *
 * 作者: zzl
 * 创建于: 2019/1/12 15:16
 */
@Controller
@RequestMapping("tuserdataController")
public class TUserDataController extends BaseController {

    @Resource
    private TUserDataService tUserDataService;

    /**
     * 跳转到普通用户列表
     * @return
     */
    @GetMapping("/showTUserdata.html")
    public String showTUserdata(){

        return "back/showTUserdata";
    }
    /**
     * 查询普通用户列表
     * @param date
     */
    @PostMapping("/tuserdatalist")
    public void queryAllTUserData(LaytableDate date){

        PageHelper page = new PageHelper();
        page.startPage(date.getPage(), date.getLimit());
        List<TUserData> tUserData = tUserDataService.queryAllTUserData(date.getName(),date.getOrder());

        Page<TUserData> listCountry = (Page<TUserData>)tUserData;
        long total = listCountry.getTotal();
        LayDates dates=new LayDates(0,"",total,tUserData);
        //sendOutPrint(tUserData);
        sendOutPrint("list",tUserData);
    }

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    public String  addUser(TUserData user) {
        user.setUsername("zzl20190128");
        user.setHeadimg("headimg13245689");
        user.setOpenid("openid123456");
        user.setToken("token123456789");
        user.setPowerid(3);
        user.setStatus(1);
        user.setCreattime(DateUtils.getNowDate());
        user.setLastuptime(DateUtils.getNowDate());
        int ok = tUserDataService.addUser(user);
        return   "back/showTUserdata";
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    public String  updateUser(TUserData user) {
        user.setId(16);
        user.setUsername("zz-------------");
        user.setHeadimg("headimg13245689");
        user.setOpenid("openid123456");
        user.setToken("token123456789");
        user.setPowerid(4);
        user.setStatus(1);
        user.setCreattime(DateUtils.getNowDate());
        user.setLastuptime(DateUtils.getNowDate());
        int ok = tUserDataService.updateUser(user);
        return   "back/showTUserdata";
    }

    /**根据id
     * 删除用户信息
     * @param id
     * @return
     */
    @PostMapping("/deleteUser")
    public String  deleteUser(Integer id) {
        int ok = tUserDataService.deleteUser(id);
        return   "back/showTUserdata";
    }


}
