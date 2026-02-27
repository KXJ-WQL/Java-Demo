package com.beans.convert;

import com.beans.dto.CarDTO;
import com.beans.vo.CarDriverVO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-07T19:31:09+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class CarConvertImpl extends CarConvert {

    @Override
    public CarDriverVO CarDTOToVO(CarDTO carDTO) {
        if ( carDTO == null ) {
            return null;
        }

        CarDriverVO carDriverVO = new CarDriverVO();

        carDriverVO.setId( carDTO.getId() );
        carDriverVO.setVin( carDTO.getVin() );
        carDriverVO.setPrice( carDTO.getPrice() );
        carDriverVO.setTotalPrice( carDTO.getTotalPrice() );
        carDriverVO.setPublishDate( carDTO.getPublishDate() );
        carDriverVO.setBrand( carDTO.getBrand() );

        CarDriverVOHandler( carDTO, carDriverVO );

        return carDriverVO;
    }
}
