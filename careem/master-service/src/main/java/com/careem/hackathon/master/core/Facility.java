package com.careem.hackathon.master.core;

import com.careem.hackathon.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by naveen.nahata on 25/02/17.
 */
@Data
@Entity
@Table(name = "facilities")
public class Facility extends BaseEntity{

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "code")
    private String code;

    @Basic
    @Column(name = "address")
    private long address;

    @Basic
    @Column(name = "type")
    private FacilityType type;

}
