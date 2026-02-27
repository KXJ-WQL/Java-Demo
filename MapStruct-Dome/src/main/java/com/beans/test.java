package com.beans;

import com.beans.dto.CarDTO;
import com.beans.dto.DriverDTO;
import com.beans.dto.PartDTO;
import com.beans.vo.CarDriverVO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author WQL-KXJ
 * @ProjectName MapStruct-Dome
 * @PackageName com.beans
 * @Date 2022/10/6 21:19
 * @Version 1.0
 */
public class test {

    public static void main(String[] args) {

        CarDTO carDto = getCarDto();

        CarDriverVO carDriverVO = new CarDriverVO();
        carDriverVO.setId(carDto.getId());
        carDriverVO.setVin(carDto.getVin());
        carDriverVO.setPrice(carDto.getPrice());
        carDriverVO.setTotalPrice(carDto.getTotalPrice());
        carDriverVO.setPublishDate(carDto.getPublishDate());

       boolean par = carDto.getPartDTOS()!=null && !carDto.getPartDTOS().isEmpty();
       carDriverVO.setPartexites(par);
       carDriverVO.setDriverName(carDto.getDriverDTO().getName());


    }


    //实在DTO并返回
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
