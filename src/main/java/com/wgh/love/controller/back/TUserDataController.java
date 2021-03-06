package com.wgh.love.controller.back;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wgh.love.controller.BaseController;
import com.wgh.love.model.LayDates;
import com.wgh.love.model.LaytableDate;
import com.wgh.love.model.TUserData;
import com.wgh.love.model.customModel.back.UserData;
import com.wgh.love.service.TUserDataService;
import com.wgh.love.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        List<UserData> userData = new ArrayList<UserData>();

        for(TUserData data : tUserData){
            UserData ud = new UserData();
            ud.setId(data.getId());
            ud.setUsername(data.getUsername());
            ud.setStatus(data.getStatus());
            ud.setToken(data.getToken());
            ud.setOpenid(data.getOpenid());
            ud.setHeadimg(data.getHeadimg());
            ud.setPowerid(data.getPowerid());
            ud.setCreattime(data.getCreattime());
            ud.setCreattimestr(DateUtils.DataToString(data.getCreattime()));
            ud.setLastuptime(data.getLastuptime());
            ud.setLastuptimestr(DateUtils.DataToString(data.getLastuptime()));

            userData.add(ud);
        }
        Page<TUserData> listCountry = (Page<TUserData>)tUserData;
        long total = listCountry.getTotal();
        LayDates dates=new LayDates(0,"",total,userData);
        //sendOutPrint(tUserData);
        sendOutPrint("list",dates);
    }

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    @ResponseBody
    public Integer  addUser(TUserData user ) {

        user.setId(null);
        user.setStatus(1);
        user.setCreattime(DateUtils.getNowDate());
        user.setLastuptime(DateUtils.getNowDate());
        int ok = tUserDataService.addUser(user);
        //sendOutPrint("result",ok);
        return   ok ;
        //return   "back/showTUserdata";
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    @ResponseBody
    public Integer  updateUser(TUserData user) {

        user.setLastuptime(DateUtils.getNowDate());
        int ok = tUserDataService.updateUser(user);

        return   ok;
    }

    /**根据id
     * 删除用户信息
     * @param id
     * @return
     */
    @PostMapping("/deleteUser")
    @ResponseBody
    public Integer  deleteUser(Integer id) {
        int ok = tUserDataService.deleteUser(id);
        return   ok;
    }


}
