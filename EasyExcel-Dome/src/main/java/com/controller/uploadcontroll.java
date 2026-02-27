package com.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.excelpojo.exceluserpojo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @Author WQL-KXJ
 * @ProjectName easyexcel-dome
 * @PackageName com.controller
 * @Date 2023/6/2 18:03
 * @Version 1.0
 */
@Controller
public class uploadcontroll {

    @RequestMapping(value = "/uploadexcel",method = RequestMethod.POST )
    @ResponseBody
    public String uploadexcel(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        EasyExcel.read(multipartFile.getInputStream(), exceluserpojo.class, new AnalysisEventListener<exceluserpojo>() {
            @Override
            public void invoke(exceluserpojo exceluserpojo, AnalysisContext analysisContext) {
                System.out.println(exceluserpojo);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("上传文件读取完成");
            }
        }).sheet().doRead();

        return "上传成功";
    }
}
