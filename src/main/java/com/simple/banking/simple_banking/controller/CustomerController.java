package com.simple.banking.simple_banking.controller;

import com.simple.banking.simple_banking.dto.CustomerDto;
import com.simple.banking.simple_banking.dto.TransferRequest;
import com.simple.banking.simple_banking.model.Customer;
import com.simple.banking.simple_banking.service.CustomerService;
import com.simple.banking.simple_banking.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PutMapping("/update/{id}")
    public Map<String, Object> updateData (@PathVariable("id")int id ,@RequestBody CustomerDto CustomerDto){
        return customerService.updateData(id, CustomerDto);
    }
    @GetMapping("/findAll")
    public List<Customer> findAll (){
        return customerService.findAll();
    }
}
