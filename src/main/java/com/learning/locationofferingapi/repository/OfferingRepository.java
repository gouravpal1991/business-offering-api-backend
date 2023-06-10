package com.learning.locationofferingapi.repository;


import com.learning.locationofferingapi.entity.OfferingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferingRepository extends CrudRepository<OfferingEntity,Long> {
}
