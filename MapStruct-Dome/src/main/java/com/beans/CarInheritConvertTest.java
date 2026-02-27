package com.beans;

import com.beans.convert.CarInheritConvert;
import com.beans.dto.CarDTO;
import com.beans.dto.DriverDTO;
import com.beans.dto.PartDTO;
import com.beans.vo.CarDriverVO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * @Author WQL-KXJ
 * @ProjectName MapStruct-Dome
 * @PackageName com.beans
 * @Date 2022/10/7 21:22
 * @Version 1.0
 */
public class CarInheritConvertTest {

    public static void main(String[] args) {

        CarDriverVO carInheritConvert =CarInheritConvert.INSTANCE.CarDTOToVO(getCarDto());

        System.out.println("更新前的对象:"+carInheritConvert);
        //更新对象
        CarDTO carDTO = new CarDTO();
        carDTO.setId(1L);
        carDTO.setVin("湘A2193");
        //通过UpdateCarDriverVO方法进行更新
        CarInheritConvert.INSTANCE.UpdateCarDriverVO(carDTO,carInheritConvert);

        //更新后的对象
        System.out.println("更新后的对象:"+carInheritConvert);
    }
    public static CarDTO getCarDto(){

        CarDTO carDTO = new CarDTO();
        carDTO.setId(1L);
        carDTO.setVin("湘Ba8921");
        carDTO.setPrice(182382.52);
        carDTO.setTotalPrice(200000.00);
        carDTO.setPublishDate(Date.valueOf(LocalDate.now()));
        carDTO.setBrand("日产");

        List<PartDTO> array= new ArrayList<>();
        PartDTO partDTO = new PartDTO();
        partDTO.setPartId(1L);
        partDTO.setPartName("方向盘");
        array.add(partDTO);

        DriverDTO driverDTO = new DriverDTO();
        driverDTO.setId(1L);
        driverDTO.setName("李某某");

        carDTO.setPartDTOS(array);
        carDTO.setDriverDTO(driverDTO);

        return carDTO;
    }
}
