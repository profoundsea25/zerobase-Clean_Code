package study.houseutils.policy;

/* 가격이 특정 범위일 때 상한효율과 상한금액 가지는 클래스 */

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BrokerageRule {
    private Double brokeragePercent;
    private Long limitAmount;

    public Long calcMaxBrokerage(Long price) {
        if (limitAmount == null) {
            return multiplyPercent(price);
        }
        return Math.min(multiplyPercent(price), limitAmount);
    }

    private Long multiplyPercent(Long price) {
        return Double.valueOf(Math.floor(brokeragePercent / 100 * price)).longValue();
    }
}
