package com.simple.banking.simple_banking.repository;

import com.simple.banking.simple_banking.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByNoRekening(String noRekening);
}
