package com.beans.convert;

import com.beans.dto.CarDTO;
import com.beans.vo.CarDriverVO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-07T21:51:58+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class CarInheritConvertImpl extends CarInheritConvert {

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

        return carDriverVO;
    }

    @Override
    public void UpdateCarDriverVO(CarDTO carDTO, CarDriverVO carDriverVO) {
        if ( carDTO == null ) {
            return;
        }

        carDriverVO.setId( carDTO.getId() );
        carDriverVO.setVin( carDTO.getVin() );
        carDriverVO.setPublishDate( carDTO.getPublishDate() );
        carDriverVO.setBrand( carDTO.getBrand() );
    }
}
