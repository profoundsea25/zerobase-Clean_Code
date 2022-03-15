package study.houseutils.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.houseutils.constant.ActionType;
import study.houseutils.policy.BrokeragePolicy;
import study.houseutils.policy.BrokeragePolicyFactory;

/* 중개 수수료 계산 API */

@RestController
public class BrokerageQueryController {

    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType,
                              @RequestParam Long price) {
        // TODO: 중개수수료 계산하는 로직
        // 분기를 나누는 것을 안 할 수는 없다. 대신 최대한 Factory에서만 분기를 나누도록 하자.
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }
}
