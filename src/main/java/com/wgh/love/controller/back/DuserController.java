/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.wgh.love.controller.back;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wgh.love.controller.BaseController;
import com.wgh.love.model.DUser;
import com.wgh.love.service.DUserService;

/**
 * 医生操作控制
 * @author Alan 创建于: 2018-1-17 下午2:43:43
 *
 */
@Controller
@RequestMapping("duserController")
public class DuserController extends BaseController {
    @Resource
    private DUserService userService;
    /**
     * 跳转到登录页面
     * @return
     */
    /*@GetMapping("/login.html")
    public String  login() {

        return  "back/login";
    }*/

    @PostMapping("/uplogin")
    public void   addPatient(DUser dUser) {

        Integer uplogin=0;

        Integer uplogin1 = userService.uplogin(dUser.getUsername());

        if (uplogin1==1){
            DUser uplogin2 = userService.uplogin(dUser);
            if (uplogin2!=null) {
            	uplogin = 1;
            	session.setAttribute("user",uplogin2);
			}else {
				uplogin = 0;
			}
            
            
        }else{
            uplogin=-1;
        }

        sendOutPrint("code",uplogin);

    }
    @PostMapping("/update.html")
    public String   update(String name,String percent) {
    	DUser updateDuser = userService.updateDuser(name, percent, GetCurUser().getId());
    	if (updateDuser!=null) {
    		session.setAttribute("user",updateDuser);
		}
    	return "back/userdata";
    }
    @PostMapping("/updatepassword.html")
    public void   updatepassword(String data1,String data2) {
    	DUser updateDuser=null;
    	String code="原密码错误!";
    	if (data1.equals(GetCurUser().getPassword())) {
    		 updateDuser = userService.updateDuser(data2, GetCurUser().getId());
		}
    	if (updateDuser!=null) {
    		session.setAttribute("user",updateDuser);
    		code="修改成功";
    	}
    	
    	sendOutPrint("code", code);
    }

    @GetMapping("/gologin.html")
    public String  login2 () {

        return "back/backindex";
    }
    @GetMapping("/loginout.html")
    public String  loginout () {
        session.setAttribute("user",null);

        return "redirect:login.html";
    }
    @GetMapping("/userdata.html")
    public String  userdata () {
    	
    	return "back/userdata";
    }
    @GetMapping("/password.html")
    public String  password () {
    	
    	return "back/password";
    }






















}
