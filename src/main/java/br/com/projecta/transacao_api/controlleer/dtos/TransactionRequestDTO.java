package br.com.projecta.transacao_api.controlleer.dtos;

import java.time.OffsetDateTime;

public record TransactionRequestDTO(
        Double value,
        OffsetDateTime hourTime
) {

}
