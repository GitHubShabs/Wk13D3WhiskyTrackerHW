package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

//    TODO: Write a query to find distilleries  by region (Speyside)
//    HAVE: String region (Speyside)
//    WANT: List<Distilleries>

    @Transactional
    public List<Distillery> findDistilleryByRegion(String region){
        List<Distillery> results = null;

        Session session = entityManager.unwrap(Session.class);

        Criteria cr = session.createCriteria(Distillery.class);
        cr.add(Restrictions.eq("region", region));

        results = cr.list();

        return results;
    }

}
