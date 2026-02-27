package com.beans.convert;

import com.beans.dto.CarDTO;
import com.beans.vo.CarDriverVO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/*
 * @Author WQL-KXJ
 * @ProjectName MapStruct-Dome
 * @PackageName com.beans.convert
 * @Date 2022/10/7 21:15
 * @Version 1.0
 */
@Mapper
public abstract class CarInheritConvert {

    //获取当前对象
    public static  CarInheritConvert INSTANCE = Mappers.getMapper(CarInheritConvert.class);

    //转换方法，参数为原实体对象，返回值为结果对象，方法为转换操作
    public abstract CarDriverVO CarDTOToVO(CarDTO carDTO);

    //对属性进行更新方法
    @InheritConfiguration
    @Mappings(value = {
            @Mapping(source = "price",target = "price",ignore = true),
            @Mapping(source = "totalPrice",target = "totalPrice",ignore = true),
    })
    abstract public void  UpdateCarDriverVO(CarDTO carDTO,@MappingTarget CarDriverVO carDriverVO);

}
