package br.com.projecta.transacao_api.controlleer;

import br.com.projecta.transacao_api.controlleer.dtos.TransactionRequestDTO;
import br.com.projecta.transacao_api.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService = new TransactionService();

    @PostMapping
    public ResponseEntity<Void> addTransaciton(@RequestBody TransactionRequestDTO trasaction ) {
        transactionService.save(trasaction);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public  ResponseEntity<List<TransactionRequestDTO>> listTransactions() {
        return ResponseEntity.ok(transactionService.allTrasactions());
    }

}
