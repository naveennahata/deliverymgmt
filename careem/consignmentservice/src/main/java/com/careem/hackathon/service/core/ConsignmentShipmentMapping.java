package com.careem.hackathon.service.core;

import com.careem.hackathon.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by rishabh.sood on 25/02/17.
 */
@Data
@Entity
@Table(name = "consignment_Shipment_mapping")
public class ConsignmentShipmentMapping extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "consignment_id")
    private Integer consignmentId;

    @Basic
    @Column(name = "shipment_id")
    private String shipmentId;
}
