package com.excelpojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentFontStyle;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.alibaba.excel.enums.poi.FillPatternTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * @Author WQL-KXJ
 * @ProjectName easyexcel-dome
 * @PackageName com.excelpojo
 * @Date 2023/5/30 21:33
 * @Version 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
//头背景设置成红色
@HeadStyle(fillPatternType = FillPatternTypeEnum.SOLID_FOREGROUND,fillForegroundColor =10)
//头字体大小设置成20
@HeadFontStyle(fontHeightInPoints = 20)
//设置内容背景颜色为蓝色
@ContentStyle(fillPatternType = FillPatternTypeEnum.SOLID_FOREGROUND,fillForegroundColor =4)
//内容字体设置成20
@ContentFontStyle(fontHeightInPoints = 20)
public class stylepojo {
    @ExcelProperty(value = "字符标题")
    private String title;

    @ExcelProperty(value = "内容")
    private String content;
}
