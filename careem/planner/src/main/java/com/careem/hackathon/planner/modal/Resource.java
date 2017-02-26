package com.careem.hackathon.planner.modal;

import com.careem.hackathon.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by naveen.nahata on 26/02/17.
 */
@Data
@Entity
@Table(name = "resource")
public class Resource extends BaseEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "vendor_ref_id")
    private String vendor_ref_id;


    @Basic
    @Column(name = "type")
    private String type;

    @Basic
    @Column(name = "resource_ref_id")
    private String resourceRefId;
}