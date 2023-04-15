package com.simple.banking.simple_banking.controller;

import com.simple.banking.simple_banking.dto.CustomerDto;
import com.simple.banking.simple_banking.dto.TransferRequest;
import com.simple.banking.simple_banking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/api")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/createNasabah", method = RequestMethod.POST)
    public Map<String,Object> createNasabah(@RequestBody CustomerDto customerDto){
        return customerService.createNasabah(customerDto);
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public Map<String,Object> transferNasabah(@RequestBody TransferRequest transferRequest){
        return customerService.transferSaldo(transferRequest);
    }
}
