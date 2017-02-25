package com.careem.hackathon.master.core;

import com.careem.hackathon.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by naveen.nahata on 25/02/17.
 */
@Data
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity{

}
