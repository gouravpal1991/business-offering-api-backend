package com.learning.locationofferingapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties()
public class OfferingModel {
    private Long id;
    private String offering;
    private String description;
    private String eligibilityCriteria;
}
