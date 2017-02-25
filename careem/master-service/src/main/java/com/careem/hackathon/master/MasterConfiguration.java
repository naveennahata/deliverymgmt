package com.careem.hackathon.master;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by naveen.nahata on 25/02/17.
 */
@Data
public class MasterConfiguration extends Configuration{
    @Valid
    @NotNull
    @JsonProperty
    private DataSourceFactory masterDatabase = new DataSourceFactory();
}
