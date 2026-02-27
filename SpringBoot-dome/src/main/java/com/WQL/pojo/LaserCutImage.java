package com.WQL.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @Author WQL-KXJ
 * @ProjectName 103-xionghuan_laser
 * @PackageName com.lxj.shoot.domain
 * @Date 2024/3/19 14:45
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaserCutImage {

    private Integer cropHeight;
    private Integer cropWidth;
    private Integer cropX;
    private Integer cropY;
    private Integer laserX;
    private Integer laserY;

}
