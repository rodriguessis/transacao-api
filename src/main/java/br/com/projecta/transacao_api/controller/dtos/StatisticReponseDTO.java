package br.com.projecta.transacao_api.controller.dtos;

public record StatisticReponseDTO(
        Long count,
        Double sum,
        Double avg,
        Double min,
        Double max) {
}
