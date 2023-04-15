package com.simple.banking.simple_banking.service;

import com.simple.banking.simple_banking.dto.CustomerDto;
import com.simple.banking.simple_banking.dto.TransferRequest;
import com.simple.banking.simple_banking.model.Customer;
import com.simple.banking.simple_banking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Map<String, Object> createNasabah(CustomerDto customerDto) {
        Map<String, Object> result = new HashMap<>();
        try {
//            Customer customer = new Customer();
            var customer = new Customer();
            customer.setName(customerDto.getName());
            customer.setAlamat(customerDto.getAlamat());
            customer.setPhone(customerDto.getPhone());
            Random random = new Random();
            int noRek = random.nextInt(10000);
            customer.setNoRekening(String.valueOf(noRek));
            if (customerDto.getSaldo() < 50000){
                result.put("status", "failed");
                result.put("message", "Saldo minimal Rp. 50.000");
                return result;
            }else {
                customer.setSaldo(customerDto.getSaldo());
            }
            customerRepository.save(customer);
            result.put("status", "success");
            result.put("message", customer);
            return result;
        } catch (Exception e) {
            result.put("status", "failed");
            result.put("message", "Gagal menambahkan data");
            return result;
        }
    }

    @Override
    public Map<String,Object> transferSaldo(TransferRequest transferRequest){
        Map<String, Object> result = new HashMap<>();
        int saldo = 50000;
        int chargeFee = 6500;
        try {
            Customer customer = customerRepository.findByNoRekening(transferRequest.getNoRekening());
            Customer customer2 = customerRepository.findByNoRekening(transferRequest.getNoRekening2());
            if(customer.getNoRekening().equalsIgnoreCase(customer2.getNoRekening())) {
                result.put("status", "failed");
                result.put("message", "Tidak bisa transfer ke rekening sendiri");
                return result;
            }
            if (customer.getSaldo() < transferRequest.getSaldo()){
                result.put("status", "failed");
                result.put("message", "Saldo tidak cukup");
                return result;
            }  else if (transferRequest.getSaldo() < saldo ) {
                // ini punya tyas & farhan
                result.put("status", "failed");
                result.put("message", "transfer tidak boleh kurang dari Rp. 50.000");
                return result;
            } else if(customer.getSaldo() < transferRequest.getSaldo() + chargeFee){
                // ini punya jul
                result.put("status", "failed");
                result.put("message", "transfer tidak mencukupi");
                return result;
            }
            else {
                customer.setSaldo(customer.getSaldo() - transferRequest.getSaldo());
                customer.setSaldo(customer.getSaldo() - chargeFee);
                customer2.setSaldo(customer2.getSaldo() + transferRequest.getSaldo());
                customerRepository.save(customer);
                customerRepository.save(customer2);
                result.put("status", "success");
                result.put("Pengirim", customer);
                result.put("Penerima", customer2);
                return result;
            }
        } catch (Exception e) {
            result.put("status", "failed");
            result.put("message", "Gagal transfer");
            return result;
        }
    }
}
