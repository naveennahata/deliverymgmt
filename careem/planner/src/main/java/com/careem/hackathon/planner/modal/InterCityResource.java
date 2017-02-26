package com.careem.hackathon.planner.modal;

import javax.persistence.*;

/**
 * Created by naveen.nahata on 26/02/17.
 */
public class InterCityResource {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "source_address_id")
    private String sourceAddressId;

    @Basic
    @Column(name = "destination_address_id")
    private String destinationAddresId;

    @Basic
    @Column(name = "capacity")
    private long capacity;

}
