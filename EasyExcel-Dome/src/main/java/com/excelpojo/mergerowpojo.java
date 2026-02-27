package com.excelpojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentLoopMerge;
import com.alibaba.excel.annotation.write.style.OnceAbsoluteMerge;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/*
 * @Author WQL-KXJ
 * @ProjectName easyexcel-dome
 * @PackageName com.excelpojo
 * @Date 2023/5/30 22:57
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
//将第2-3行的2-3列合并成一个单元格
@OnceAbsoluteMerge(firstRowIndex = 2,lastRowIndex = 3,firstColumnIndex = 1,lastColumnIndex = 2)
public class mergerowpojo {

    @ExcelProperty(value = "字符串标题")
    private String str;

    //这一列每隔2行合并单元格
    @ContentLoopMerge(eachRow = 2)
    @ExcelProperty(value = "日期标题")
    private Date date;

    @ExcelProperty(value = "数字标题")
    private Double aDouble;
}
