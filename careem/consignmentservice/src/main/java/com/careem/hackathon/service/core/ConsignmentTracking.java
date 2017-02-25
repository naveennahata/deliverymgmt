package com.careem.hackathon.service.core;

import com.careem.hackathon.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by rishabh.sood on 25/02/17.
 */
@Data
@Entity
@Table(name = "consignment_tracking")
public class ConsignmentTracking extends BaseEntity {
    @Id
    @Column(name = "consignment_tracking_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "consignment_id")
    private Integer consignmentId;

    @Basic
    @Column(name = "current_address_id")
    private String currentAddress;

    @Basic
    @Column(name = "destination_address_id")
    private String destinationAddress;

    @Basic
    @Column(name = "source_address_id")
    private String sourceAddress;

    @Basic
    @Column(name = "assigned_address_id")
    private String assignedAddress;

    @Basic
    @Column(name = "vendor_id")
    private int vendorId;
}
