package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

//    TODO: write a query to find a whisky from 2018
//    HAVE: int whisky-year
//    WANT: List<Whiskies>

    @Transactional
    public List<Whisky> findWhiskyByYear(int year){
        List<Whisky> results = null;

        Session session = entityManager.unwrap(Session.class);

        Criteria cr = session.createCriteria(Whisky.class);
        cr.add(Restrictions.eq("year",year));

        results = cr.list();

        return results;

    }

}
