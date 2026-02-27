package com.beans.vo;

import com.beans.dto.DriverDTO;
import com.beans.dto.PartDTO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/*
 * @Author WQL-KXJ
 * @ProjectName MapStruct-Dome
 * @PackageName com.beans.vo
 * @Date 2022/10/6 20:28
 * @Version 1.0
 */
@Data
@ToString
public class CarDriverVO {
    //编号
    private Long id;

    //车辆编号
    private String vin;

    //裸车价格
    private double price;

    //上路价格
    private double totalPrice;

    //生成日期
    private Date publishDate;

    //品牌名称
    private  String brand;

    //是否配置了零件
    private boolean partexites;

    //汽车司机名称
    private String driverName;
}
