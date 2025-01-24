package br.com.projecta.transacao_api.services;

import br.com.projecta.transacao_api.controlleer.dtos.TransactionRequestDTO;
import br.com.projecta.transacao_api.infrastructure.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionService {

    private static final Logger log = LoggerFactory.getLogger(TransactionService.class);
    private final List<TransactionRequestDTO> listTrasaction = new ArrayList<>();


}
