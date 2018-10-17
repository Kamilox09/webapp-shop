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
        Query query = getSession().createQuery("from Customer where login =:username");
        query.setParameter("username",username);
        return (Customer)query.uniqueResult();
    }

    @Override
    public Customer addNewCustomer(Customer customer) {
        create(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Query query = getSession().createQuery("update Customer set name=:name, surname=:surname, company=:company,phoneNumber=:phoneNumber,nip=:nip,regon=:regon where customerId=:customerId");
        query.setParameter("name",customer.getName());
        query.setParameter("surname",customer.getSurname());
        query.setParameter("company",customer.getCompany());
        query.setParameter("phoneNumber",customer.getPhoneNumber());
        query.setParameter("nip",customer.getNip());
        query.setParameter("regon",customer.getRegon());
        query.setParameter("customerId",customer.getCustomerId());
        query.executeUpdate();
        return customer;
    }
}
