package com.beans.convert;

import com.beans.dto.CarDTO;
import com.beans.vo.CarDriverVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

/*
 * @Author WQL-KXJ
 * @ProjectName MapStruct-Dome
 * @PackageName com.beans.convert
 * @Date 2022/10/7 16:18
 * @Version 1.0
 */
@Mapper
public abstract class CarMapConvert {

    //获取当前对象
    public static  CarMapConvert INSTANCE = Mappers.getMapper(CarMapConvert.class);

    //转换方法，参数为原实体对象，返回值为结果对象，方法为转换操作

    @Mappings(value = {
            @Mapping(source ="driverDTO.name" ,target = "driverName"),
            @Mapping(source = "publishDate",target = "publishDate")
    })
    public abstract CarDriverVO CarDTOToVO(CarDTO carDTO);

}
