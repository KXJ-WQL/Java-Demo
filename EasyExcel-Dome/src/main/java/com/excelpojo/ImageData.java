package com.excelpojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.converters.string.StringImageConverter;
import com.alibaba.excel.converters.url.UrlImageConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/*
 * @Author WQL-KXJ
 * @ProjectName easyexcel-dome
 * @PackageName com.excelpojo
 * @Date 2023/5/30 16:59
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class ImageData {
    //使用抽象文件表示一个图片
    private File file;

    //使用输入流保存一个文件
    private InputStream inputStream;

    //使用String类型表示保存一个图片，需要使用StringImageConverter转换器
    @ExcelProperty(converter = StringImageConverter.class)
    private String imgStr;

    //使用二进制数据保存为一种图片
    private  byte[] byteArray;

    //使用网络链接保存一个图片
    private URL url;
}
