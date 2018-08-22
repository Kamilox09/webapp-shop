package com.webapp.dao.impl;

import com.webapp.dao.CustomerDao;
import com.webapp.model.entity.Customer;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Customer> implements CustomerDao {
    @Override
    public Customer getCustomerByUsername(String username) {
        Query query = getSession().createQuery("from Customer where USERNAME =:username");
        query.setParameter("username",username);
        return (Customer)query.uniqueResult();
    }
}
