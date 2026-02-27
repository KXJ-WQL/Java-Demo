package com.excelpojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.*;

import java.util.Date;

/*
 * @Author WQL-KXJ
 * @ProjectName easyexcel-dome
 * @PackageName com.excelpojo
 * @Date 2023/5/30 12:36
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
public class dataformatpojo {

    @NumberFormat("#.##")
    @ExcelProperty(value = "工资")
    private String salary;

    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty(value = "入职时间")
    private Date hireDate;
}
