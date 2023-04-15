package com.simple.banking.simple_banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferResponse {
    private String noRekening;
    private String noRekening2;
    private int saldo;
    private LocalDateTime waktu;
    private String dekripsi;
}
