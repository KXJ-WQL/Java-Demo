package com.beans.dto;

import lombok.Data;

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
public class CarDTO {

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

    //车辆零件列表
    private List<PartDTO> partDTOS;

    //汽车司机
    private DriverDTO driverDTO;
}
