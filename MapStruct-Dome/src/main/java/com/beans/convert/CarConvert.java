package com.beans.convert;

import com.beans.dto.CarDTO;
import com.beans.vo.CarDriverVO;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/*
 * @Author WQL-KXJ
 * @ProjectName MapStruct-Dome
 * @PackageName com.beans.convert
 * @Date 2022/10/6 23:23
 * @Version 1.0
 */
@Mapper
public abstract class CarConvert {

    //获取当前对象
    public static  CarConvert INSTANCE = Mappers.getMapper(CarConvert.class);

    //转换方法，参数为原实体对象，返回值为结果对象，方法为转换操作
    @BeanMapping
    public abstract CarDriverVO CarDTOToVO(CarDTO carDTO);

//    @AfterMapping
//    public void  CarDriverVOHandler(CarDTO carDTO,@MappingTarget CarDriverVO carDriverVO){
//
//        System.out.println("执行了后置处理方法");
//        boolean par = carDTO.getPartDTOS()!=null && !carDTO.getPartDTOS().isEmpty();
//        carDriverVO.setPartexites(par);
//    }

}
