package com.learning.locationofferingapi.controller;

import com.learning.locationofferingapi.model.OfferingModel;
import com.learning.locationofferingapi.service.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class OfferingController {
    @Autowired
    private OfferingService offeringService;

    @GetMapping("/offerings")
    public ResponseEntity<List<OfferingModel>> getAllOfferings() {
        List<OfferingModel> modelList = offeringService.getAllOfferings();
        return new ResponseEntity<>(modelList, HttpStatus.OK);
    }

    @GetMapping("/offerings/{offeringId}")
    public ResponseEntity<OfferingModel> getOfferingById(@PathVariable("offeringId") Long offeringId) {
        OfferingModel offeringModel = offeringService.getOfferingById(offeringId);
        return new ResponseEntity<>(offeringModel, HttpStatus.OK);
    }

    @PostMapping("/offerings")
    public ResponseEntity<String> createMapping(@RequestBody OfferingModel model) {
        boolean result = offeringService.createOffering(model);

        if (result) {
            return new ResponseEntity<>("Offering created!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Offering could not be created!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
