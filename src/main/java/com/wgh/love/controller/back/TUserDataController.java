package com.wgh.love.controller.back;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wgh.love.controller.BaseController;
import com.wgh.love.model.LayDates;
import com.wgh.love.model.LaytableDate;
import com.wgh.love.model.TUserData;
import com.wgh.love.service.TUserDataService;
import org.springframework.stereotype.Controller;
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

}
