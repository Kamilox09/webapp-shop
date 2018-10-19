package com.webapp.dao.impl;


import com.webapp.dao.AddressDao;
import com.webapp.model.entity.Address;
import com.webapp.model.entity.Customer;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Transactional
@Repository("addressDao")
public class AddressDaoImpl extends AbstractDao<Address> implements AddressDao {
    @Override
    public Address addNewAddress(Address address) {
        create(address);
        return address;
    }

    @Override
    public Address getCurrentAddressByCustomer(Customer customer) {
        Query query = getSession().createQuery("from Address  where customer=:customer and toDate is null");
        query.setParameter("customer",customer);
        return (Address)query.uniqueResult();
    }
}
