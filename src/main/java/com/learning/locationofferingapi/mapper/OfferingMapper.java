package com.learning.locationofferingapi.mapper;

import com.learning.locationofferingapi.entity.OfferingEntity;
import com.learning.locationofferingapi.model.OfferingModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface OfferingMapper {
   OfferingMapper INSTANCE = Mappers.getMapper(OfferingMapper.class);

   OfferingEntity convertModelToEntity(OfferingModel offeringModel);

   OfferingModel convertEntityToModel(OfferingEntity offeringEntity);
}
