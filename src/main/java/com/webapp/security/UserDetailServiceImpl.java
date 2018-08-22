package com.webapp.security;


import com.webapp.model.entity.Customer;
import com.webapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer;
        try{
            customer = customerService.getCustomerByUsername(username);
        }catch(RuntimeException e){
            throw new UsernameNotFoundException("User not found");
        }

        return new UserDetailsImpl(customer);
    }
}
