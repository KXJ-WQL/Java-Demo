package com.beans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @Author WQL-KXJ
 * @ProjectName MapStruct-Dome
 * @PackageName com.beans.dto
 * @Date 2022/10/6 20:16
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO { //司机

    private Long id;

    private String name;

}
