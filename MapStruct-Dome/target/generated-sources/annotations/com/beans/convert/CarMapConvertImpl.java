package com.beans.convert;

import com.beans.dto.CarDTO;
import com.beans.dto.DriverDTO;
import com.beans.vo.CarDriverVO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-07T21:35:45+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class CarMapConvertImpl extends CarMapConvert {

    @Override
    public CarDriverVO CarDTOToVO(CarDTO carDTO) {
        if ( carDTO == null ) {
            return null;
        }

        CarDriverVO carDriverVO = new CarDriverVO();

        carDriverVO.setDriverName( carDTODriverDTOName( carDTO ) );
        carDriverVO.setPublishDate( carDTO.getPublishDate() );
        carDriverVO.setId( carDTO.getId() );
        carDriverVO.setVin( carDTO.getVin() );
        carDriverVO.setPrice( carDTO.getPrice() );
        carDriverVO.setTotalPrice( carDTO.getTotalPrice() );
        carDriverVO.setBrand( carDTO.getBrand() );

        return carDriverVO;
    }

    private String carDTODriverDTOName(CarDTO carDTO) {
        if ( carDTO == null ) {
            return null;
        }
        DriverDTO driverDTO = carDTO.getDriverDTO();
        if ( driverDTO == null ) {
            return null;
        }
        String name = driverDTO.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
