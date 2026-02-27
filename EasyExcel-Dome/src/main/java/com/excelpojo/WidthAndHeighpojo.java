package com.excelpojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.converters.string.StringImageConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * @Author WQL-KXJ
 * @ProjectName easyexcel-dome
 * @PackageName com.excelpojo
 * @Date 2023/5/30 19:37
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@ContentRowHeight(30)//设置内容高度
@HeadRowHeight(40)//设置标题高度
@ColumnWidth(25)//设置列宽
public class WidthAndHeighpojo {

    @ExcelProperty(value = "字符标题")
    private String title;

    @ExcelProperty(value = "内容")
    private String content;

    @ExcelProperty(value = "图片",converter= StringImageConverter.class)
    private String image;

}
