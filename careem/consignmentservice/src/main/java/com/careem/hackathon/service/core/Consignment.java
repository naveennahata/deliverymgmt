package com.careem.hackathon.service.core;

import com.careem.hackathon.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by rishabh.sood on 25/02/17.
 */
@Data
@Entity
@Table(name = "consignment")
public class Consignment extends BaseEntity {
    @Id
    @Column(name = "consignment_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "user_id")
    private Integer userId;

    @Basic
    @Column(name = "start_address")
    private String startAddress;

    @Basic
    @Column(name = "end_address")
    private String endAddress;

    @Basic
    @Column(name = "status")
    private String status;

    @Basic
    @Column(name = "type")
    private String type;
}