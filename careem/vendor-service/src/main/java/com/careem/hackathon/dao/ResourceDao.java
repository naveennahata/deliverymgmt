package com.careem.hackathon.dao;

import com.careem.hackathon.api.ResourceRequest;
import com.careem.hackathon.repository.VendorManagmentRepository;
import com.careem.hackathon.service.core.Resource;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

/**
 * Created by aakash.jindal on 26/02/17.
 */
public class ResourceDao extends AbstractDAO<Resource> implements VendorManagmentRepository {

    @Inject
    public ResourceDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    public void createResource(ResourceRequest resourceRequest) {
        Resource resource = new Resource();
        resource.setUserId(resourceRequest.getUserId());
        resource.setResourceType(resourceRequest.getResourceType());
        this.currentSession().persist(resource);
    }
}

