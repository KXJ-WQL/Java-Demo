package com.excelpojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;

/*
 * @Author WQL-KXJ
 * @ProjectName easyexcel-dome
 * @PackageName com.excelpojo
 * @Date 2023/5/30 12:03
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
public class themeuserpojo {
    @ExcelProperty(value = {"用户信息","用户编号"})
    private Integer userId;

    @ExcelProperty(value = {"用户信息","姓名"})
    private String userName;

    @ExcelProperty(value = {"其他信息","性别"})
    private String gender;

    @ExcelProperty(value = {"其他信息","工资"})
    private Double salary;
}
