package com.learning.locationofferingapi.service;

import com.learning.locationofferingapi.model.OfferingModel;

import java.util.List;

public interface OfferingService {
    boolean createOffering(OfferingModel offertingModel);
    List<OfferingModel> getAllOfferings();

    OfferingModel getOfferingById(Long id);
}
