package study.houseutils.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.houseutils.constant.ActionType;
import study.houseutils.policy.BrokeragePolicy;
import study.houseutils.policy.BrokeragePolicyFactory;

/**
 * @author profoundsea25
 *
 * 중개 수수료가 얼마인지 조회하는 컨트롤러
 */
@RestController
public class BrokerageQueryController {

    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType,
                              @RequestParam Long price) {
        // 분기를 나누는 것을 안 할 수는 없다. 대신 최대한 Factory에서만 분기를 나누도록 하자.
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }

    @GetMapping("/api/calc/apartment/{apartmentId}")
    public long calcBrokerageByApartmentId(@PathVariable Long apartmentId,
                                           @RequestParam ActionType actionType) {
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        Long price = 0L; // TODO : apartmentId -> price
        return policy.calculate(price);
    }
}
