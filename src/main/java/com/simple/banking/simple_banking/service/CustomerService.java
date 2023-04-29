package com.simple.banking.simple_banking.service;

import com.simple.banking.simple_banking.dto.CustomerDto;
import com.simple.banking.simple_banking.dto.TransferRequest;
import com.simple.banking.simple_banking.model.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    Map<String, Object> updateData(int id, CustomerDto CustomerDto);

    Map<String, Object> createNasabah(CustomerDto customerDto);

    Map<String,Object> transferSaldo(TransferRequest transferRequest);

    List<Customer> findAll();

    Map<String,Object>updateSaldo(int id, CustomerDto customerDto);
}
