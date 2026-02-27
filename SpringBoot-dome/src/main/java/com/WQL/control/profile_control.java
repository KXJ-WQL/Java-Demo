package com.WQL.control;

import com.WQL.profileinterface.profilebean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*
 * @Author WQL-KXJ
 * @ProjectName SpringBoot-dome
 * @PackageName com.WQL.control
 * @Date 2024/3/16 13:05
 * @Version 1.0
 */
//@RestController
public class profile_control {

    @Value("${profiless.name}")
    String profileName;

    @Value("${os.name}")
    String systemname;

    @RequestMapping(method= RequestMethod.GET,value = "/profilename")
    private String getProfileName(){
        return "配置文件值:"+profileName+"\n"+"环境变量值:"+systemname;
    }


//    @RequestMapping(method= RequestMethod.GET,value = "/profileautowired")
//    private String getProfileAutowired(){
//        return "配置文件"+profileBean.toString();
//    }
}
