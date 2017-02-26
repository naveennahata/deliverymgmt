package com.careem.hackathon.promise.engine.db;

import com.careem.hackathon.promise.engine.modal.Plan;
import com.careem.hackathon.promise.engine.modal.ShipmentPlanResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.jackson.Jackson;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by naveen.nahata on 26/02/17.
 */
public class PlanAccessorDao extends AbstractDAO<PlanAccessor> implements PlanAccessorRepository {

    final protected ObjectMapper mapper;

    @Inject
    public PlanAccessorDao(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.mapper = Jackson.newObjectMapper();
    }

    public ShipmentPlanResponse getShipmentPlanResponse(String key) {
        String payload = get(key).getValue();
        try {
            List<Plan> planList = mapper.readValue(payload, mapper.getTypeFactory().constructCollectionType(List.class, Plan.class));
            return new ShipmentPlanResponse(planList);
        } catch (IOException e) {
            return null;
        }
    }
}
