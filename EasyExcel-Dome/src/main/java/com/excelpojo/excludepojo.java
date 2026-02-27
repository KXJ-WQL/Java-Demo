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
 * @Date 2023/5/31 0:43
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
public class excludepojo {
    @ExcelProperty(value = "用户编号")
    private Integer userId;

    @ExcelProperty(value = "姓名")
    private String userName;

    @ExcelProperty(value = "性别")
    private String gender;
}
