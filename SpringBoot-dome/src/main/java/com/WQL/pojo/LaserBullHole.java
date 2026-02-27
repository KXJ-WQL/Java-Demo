package com.WQL.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * @Author WQL-KXJ
 * @ProjectName shoot
 * @PackageName com.lxj.shoot.domain
 * @Date 2024/3/18 16:10
 * @Version 1.0
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LaserBullHole {

    private String angle;
    private Integer cropHeight;
    private Integer cropWidth;
    private Integer cropX;
    private Integer cropY;
    private Integer laserX;
    private Integer laserY;
    private Integer laserRelativeX;
    private Integer laserRelativeY;
    private Integer radius;
    private String score;
}
