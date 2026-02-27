package com.beans.convert;

import com.beans.dto.CarDTO;
import com.beans.vo.CarDriverVO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/*
 * @Author WQL-KXJ
 * @ProjectName MapStruct-Dome
 * @PackageName com.beans.convert
 * @Date 2022/10/7 19:54
 * @Version 1.0
 */
@Mapper
public abstract class CarConvertList {

    //获取当前对象
    public static  CarConvertList INSTANCE = Mappers.getMapper(CarConvertList.class);

    //转换方法，参数为原实体对象，返回值为结果对象，方法为转换操作

    public abstract List<CarDriverVO> CarDTOToVO(List<CarDTO> carDTO);
}
