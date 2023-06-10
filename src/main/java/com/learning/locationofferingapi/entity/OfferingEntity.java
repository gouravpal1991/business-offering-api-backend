package com.learning.locationofferingapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "offering_table")
public class OfferingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 50)
    private String offering;
    private String description;
    private String eligibilityCriteria;

}
