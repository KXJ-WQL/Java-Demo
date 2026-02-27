package com.beans.convert;

import com.beans.dto.CarDTO;
import com.beans.vo.CarDriverVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-07T23:43:18+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
public class CarConvertListImpl extends CarConvertList {

    @Override
    public List<CarDriverVO> CarDTOToVO(List<CarDTO> carDTO) {
        if ( carDTO == null ) {
            return null;
        }

        List<CarDriverVO> list = new ArrayList<CarDriverVO>( carDTO.size() );
        for ( CarDTO carDTO1 : carDTO ) {
            list.add( carDTOToCarDriverVO( carDTO1 ) );
        }

        return list;
    }

    protected CarDriverVO carDTOToCarDriverVO(CarDTO carDTO) {
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
}
