package com.learning.locationofferingapi.service.impl;

import com.learning.locationofferingapi.entity.OfferingEntity;
import com.learning.locationofferingapi.mapper.OfferingMapper;
import com.learning.locationofferingapi.model.OfferingModel;
import com.learning.locationofferingapi.repository.OfferingRepository;
import com.learning.locationofferingapi.service.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class OfferingServiceImpl implements OfferingService {
    @Autowired
    private OfferingRepository offeringRepository;

    @Override
    public boolean createOffering(OfferingModel offeringModel) {
        OfferingEntity entity = OfferingMapper.INSTANCE.convertModelToEntity(offeringModel);
        OfferingEntity savedEntity = offeringRepository.save(entity);
        if (savedEntity != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<OfferingModel> getAllOfferings() {
        List<OfferingModel> modelList = new ArrayList<>();
        Iterable<OfferingEntity> offeringEntityIterable = offeringRepository.findAll();
        Consumer<OfferingEntity> offeringEntityConsumer =
                (offeringEntity) -> modelList.add(OfferingMapper.INSTANCE.convertEntityToModel(offeringEntity));

        offeringEntityIterable.forEach(offeringEntityConsumer);

        return modelList;
    }

    @Override
    public OfferingModel getOfferingById(Long id) {
        OfferingModel model =null;
        Optional<OfferingEntity> offeringEntityOptional = offeringRepository.findById(id);
        if(offeringEntityOptional.isPresent()){
            model = OfferingMapper.INSTANCE.convertEntityToModel(offeringEntityOptional.get());
        }
        return model;
    }
}
