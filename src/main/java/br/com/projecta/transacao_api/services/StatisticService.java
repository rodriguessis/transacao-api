package br.com.projecta.transacao_api.services;

import br.com.projecta.transacao_api.controller.dtos.StatisticReponseDTO;
import br.com.projecta.transacao_api.controller.dtos.TransactionRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Slf4j
@Service
public class StatisticService {

    private static final Logger log = LoggerFactory.getLogger(StatisticService.class);

    public final TransactionService transactionService;

    public StatisticService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public StatisticReponseDTO calculeStatistic( Integer intervalTime ) {
        List<TransactionRequestDTO> listTransactions = transactionService.listTransactions(intervalTime);
        DoubleSummaryStatistics  summaryStatistics = listTransactions.stream()
                .mapToDouble(TransactionRequestDTO::value)
                .summaryStatistics();

        log.info(summaryStatistics.toString());

        return new StatisticReponseDTO(
                summaryStatistics.getCount(),
                summaryStatistics.getSum(),
                summaryStatistics.getAverage(),
                summaryStatistics.getMin(),
                summaryStatistics.getMax() );

    }
}
