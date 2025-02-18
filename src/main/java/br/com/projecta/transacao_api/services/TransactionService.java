package br.com.projecta.transacao_api.services;

import br.com.projecta.transacao_api.controller.dtos.TransactionRequestDTO;
import br.com.projecta.transacao_api.infrastructure.exceptions.UnprocessableEntity;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TransactionService {

    private static final Logger log = LoggerFactory.getLogger(TransactionService.class);
    private final List<TransactionRequestDTO> listTrasaction = new ArrayList<>();

    public void save( TransactionRequestDTO transaction ) {

        if ( transaction.hourTime().isAfter(OffsetDateTime.now()) ) {
            log.error("Data incorreta para a Transação");
            throw new UnprocessableEntity("Data incorreta para a Transação");
        }
        if ( transaction.value() <= 0 ) {
            log.error("O valor deve ser maior que 0");
            throw new UnprocessableEntity("O valor deve ser maior que 0");
        }

        log.info("add " + transaction.toString());
        listTrasaction.add( transaction );
    }

    public List<TransactionRequestDTO> allTrasactions() {
        return listTrasaction;
    }

    public void removeAllTransactions() {
        listTrasaction.clear();
    }

    public List<TransactionRequestDTO> listTransactions( Integer interval ) {
        OffsetDateTime hoursTimeInterval = OffsetDateTime.now().minusSeconds(interval);

        return listTrasaction
                    .stream()
                    .filter( transaction -> transaction.hourTime().isAfter(hoursTimeInterval))
                    .toList();
    }

}
