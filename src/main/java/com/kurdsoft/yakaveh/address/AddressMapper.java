package com.kurdsoft.yakaveh.address;

import com.kurdsoft.yakaveh.User.UserMapper;
import com.kurdsoft.yakaveh.common.base.LocationDTO;
import com.kurdsoft.yakaveh.finalbasket.FinalBasketMapper;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface AddressMapper {

    @Mappings({
            @Mapping(source ="locationDTO",target = "location",qualifiedByName = "LocationDtOToLocation")
    })
    Address toAddress(AddressDTO addressDTO);

    @Mappings({
            @Mapping(source = "location",target = "locationDTO",qualifiedByName = "locationToLocationDTO")   })

    AddressDTO toAddressDto(Address address);

    List<Address> toAddressList(List<AddressDTO> addressDTOS);
    List<AddressDTO> toAddressDtos(List<Address>  addresses);


    @Named("LocationDtOToLocation")
    default Point<G2D> convertLocationDtOToLocation(LocationDTO locationDTO){
        Point<G2D>g2DPoint= Geometries.mkPoint(new G2D(locationDTO.getLng(), locationDTO.getLat()),
                CoordinateReferenceSystems.WGS84);
        return g2DPoint;

    }


    @Named("locationToLocationDTO")
    default com.kurdsoft.yakaveh.common.base.LocationDTO convertlLocationToLocationDTO(Point<G2D> point){
        G2D g2D=point.getPosition();
        com.kurdsoft.yakaveh.common.base.LocationDTO locationDTO=new LocationDTO();
        locationDTO.setLat(g2D.getLat());
        locationDTO.setLng(g2D.getLon());
        return locationDTO;

    }
}

