package com.careem.hackathon.service.core;

import com.careem.hackathon.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by aakash.jindal on 25/02/17.
 */
@Data
@Entity
@Table(name = "resources")
public class IntercityResource extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "resource_id")
    private String userId;

    @Basic
    @Column(name = "capacity")
    private int capacity;

    @Basic
    @Column(name = "cost")
    private int cost;

    @Basic
    @Column(name = "source_id")
    private String sourceId;

    @Basic
    @Column(name = "destination_id")
    private String destinationId;
}
