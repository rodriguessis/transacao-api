package br.com.projecta.transacao_api.services;

import br.com.projecta.transacao_api.controller.dtos.TransactionRequestDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    @Test
    @DisplayName("Deve conseguir adicionar uma transação")
    void save() {

        var transactionService = new TransactionService();
        var dao = new TransactionRequestDTO(1.0, OffsetDateTime.now());
        transactionService.save(dao);

        var listResponse = transactionService.allTrasactions();
        var transactionResponse = listResponse.get(0);

        assertTrue(listResponse.size() == 1);
        assertTrue(transactionResponse.value() == dao.value());
        assertTrue(transactionResponse.hourTime() == dao.hourTime());


    }
}