package com.careem.hackathon.master.core;

import com.careem.hackathon.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by naveen.nahata on 25/02/17.
 */
@Data
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity{

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "address_line1")
    private String address_line1;

    @Basic
    @Column(name = "address_line2")
    private String address_line2;

    @Basic
    @Column(name = "city")
    private String city;

    @Basic
    @Column(name = "state")
    private String state;

    @Basic
    @Column(name = "country")
    private String country;

    @Basic
    @Column(name = "postal_code")
    private String postal_code;
}
