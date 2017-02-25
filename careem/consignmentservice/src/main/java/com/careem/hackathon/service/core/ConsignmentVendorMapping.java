package com.careem.hackathon.service.core;

import com.careem.hackathon.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rishabh.sood on 25/02/17.
 */
@Data
@Entity
@Table(name = "consignment_vendor_mapping")
public class ConsignmentVendorMapping extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "consignment_id")
    private Integer consignmentId;

    @Basic
    @Column(name = "vendor_id")
    private String vendorId;

    @Basic
    @Column(name = "promised_date")
    private Date promisedDate;

    @Basic
    @Column(name = "consignment_cost")
    private String consignmentCost;

    @Basic
    @Column(name = "start_address_id")
    private String startAddress;

    @Basic
    @Column(name = "end_address_id")
    private int endAddress;
}
