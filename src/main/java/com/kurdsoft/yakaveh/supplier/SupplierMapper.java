package com.kurdsoft.yakaveh.supplier;


import com.kurdsoft.yakaveh.category.CategoryMapper;
import com.kurdsoft.yakaveh.common.base.LocationDTO;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring",uses = {CategoryMapper.class})
public interface SupplierMapper {


    @Mappings({
            @Mapping(source ="locationDTO",target = "location",qualifiedByName = "LocationDtOToLocation")
    })

    Supplier toSupplier(SupplierDTO supplierDTO);

    @Mappings({
            @Mapping(source = "location",target = "locationDTO",qualifiedByName = "locationToLocationDTO")   })

        SupplierDTO toSupplierDto(Supplier supplier);

    List<Supplier> toSupplierList(List<SupplierDTO> supplierDTOList);
    List<SupplierDTO> toSupplierDtos(List<Supplier>  suppliers);


    @Named("LocationDtOToLocation")
    default Point<G2D> convertLocationDtOToLocation(LocationDTO locationDTO){
        Point<G2D>g2DPoint= Geometries.mkPoint(new G2D(locationDTO.getLng(), locationDTO.getLat()),
                CoordinateReferenceSystems.WGS84);
        return g2DPoint;

    }


    @Named("locationToLocationDTO")
    default LocationDTO  convertlLocationToLocationDTO(Point<G2D> point){
        G2D g2D=point.getPosition();
        LocationDTO locationDTO=new LocationDTO();
        locationDTO.setLat(g2D.getLat());
        locationDTO.setLng(g2D.getLon());
        return locationDTO;

    }
}
