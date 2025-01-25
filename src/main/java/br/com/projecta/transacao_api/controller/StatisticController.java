package br.com.projecta.transacao_api.controller;

import br.com.projecta.transacao_api.controller.dtos.StatisticReponseDTO;
import br.com.projecta.transacao_api.services.StatisticService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistic")
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping
    public ResponseEntity<StatisticReponseDTO> findStatistics(
            @RequestParam(
                    name = "intervalTimeSeconds",
                    required = false,
                    defaultValue = "60") Integer intervalTimeSeconds
    ) {
        return ResponseEntity.ok(statisticService.calculeStatistic(intervalTimeSeconds));
    }

}
