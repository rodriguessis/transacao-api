package br.com.projecta.transacao_api.controller;

import br.com.projecta.transacao_api.controller.dtos.TransactionRequestDTO;
import br.com.projecta.transacao_api.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> addTransaciton(@RequestBody TransactionRequestDTO trasaction ) {
        transactionService.save(trasaction);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public  ResponseEntity<List<TransactionRequestDTO>> listTransactions() {
        return ResponseEntity.ok(transactionService.allTrasactions());
    }

    @DeleteMapping
    public ResponseEntity<Void> removeTransactions() {
        transactionService.removeAllTransactions();
        return ResponseEntity.ok().build();
    }

}
