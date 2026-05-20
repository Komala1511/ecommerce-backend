package com.ecommerce.service;

import com.ecommerce.dto.request.CustomerRequestDTO;
import com.ecommerce.dto.response.CustomerResponseDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    //CREATE
     public CustomerResponseDTO createCustomer(CustomerRequestDTO requestDTO)
     {
         Customer customer= new Customer();
         customer.setName(requestDTO.getName());
         customer.setEmail(requestDTO.getEmail());
         customer.setPhone(requestDTO.getPhone());
         customer.setAddress(requestDTO.getAddress());

         Customer savedcustomer=customerRepository.save(customer);
         return convertToResponseDTO(savedcustomer);

     }

}
