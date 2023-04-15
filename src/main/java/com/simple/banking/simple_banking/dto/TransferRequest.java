package com.simple.banking.simple_banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequest {

    private String noRekening;
    private String noRekening2;
    private int saldo;
    private String dekripsi;
}
