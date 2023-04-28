package com.simple.banking.simple_banking.service;

import com.simple.banking.simple_banking.dto.CustomerDto;
import com.simple.banking.simple_banking.dto.TransferRequest;

import java.util.Map;

public interface CustomerService {
    Map<String, Object> updateData(int id, CustomerDto CustomerDto);

    Map<String, Object> createNasabah(CustomerDto customerDto);

    Map<String,Object> transferSaldo(TransferRequest transferRequest);

}
