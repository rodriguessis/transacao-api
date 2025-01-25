package br.com.projecta.transacao_api.controlleer;

import br.com.projecta.transacao_api.controlleer.dtos.TransactionRequestDTO;
import br.com.projecta.transacao_api.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
