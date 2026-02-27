package com.controller;

import com.alibaba.excel.EasyExcel;
import com.excelpojo.exceluserpojo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * @Author WQL-KXJ
 * @ProjectName easyexcel-dome
 * @PackageName com.controller
 * @Date 2023/6/2 18:02
 * @Version 1.0
 */
@Controller
public class downloadcontroll {

    @RequestMapping("/downloadexcel")
    public void downloadexcel(HttpServletResponse response) throws IOException {
        //设置响应类型和编码
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        //下载的文件名
        String filename = "测试表.xlsx";
        //文件名的中文名称编码设置
        filename = URLEncoder.encode(filename,"utf-8");
        //下载文件方式(1.附件下载 2.在当前浏览器打开)
        response.setHeader("Content-disposition","attachment;filename="+filename);
        //根据exceluserpojo模板构建数据
        List<exceluserpojo> exceluserpojos = new ArrayList<exceluserpojo>();
        exceluserpojos.add(new exceluserpojo(1,"空想家","男","4000.99",new Date()));
        exceluserpojos.add(new exceluserpojo(2,"晴天","女","6000.99",new Date()));
        exceluserpojos.add(new exceluserpojo(3,"项庄","男","3000.99",new Date()));
        //输出流使用HttpServletResponse获取
        EasyExcel.write(response.getOutputStream(),exceluserpojo.class).sheet().doWrite(exceluserpojos);
    }

}
