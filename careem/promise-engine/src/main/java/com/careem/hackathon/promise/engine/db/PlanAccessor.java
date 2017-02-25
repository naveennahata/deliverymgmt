package com.careem.hackathon.promise.engine.db;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by naveen.nahata on 26/02/17.
 */
@Data
@Entity
@Table(name = "plan")
public class PlanAccessor {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Basic
    @Column(name = "value")
    private String value;

}
