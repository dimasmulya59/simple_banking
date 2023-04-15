package com.simple.banking.simple_banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String name;
    private String alamat;
    private String phone;
    private String noRekening;
    private int saldo;
}
