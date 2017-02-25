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
public class Resource extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "user_id")
    private String userId;

    @Basic
    @Column(name = "type")
    private String type;
}