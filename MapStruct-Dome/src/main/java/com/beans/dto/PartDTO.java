package com.beans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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
public class PartDTO { //零件

    private Long partId;

    private String partName;

}
