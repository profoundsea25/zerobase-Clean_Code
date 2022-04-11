package study.houseutils.policy;

import study.houseutils.constant.ActionType;
import study.houseutils.exception.ErrorCode;
import study.houseutils.exception.HouseUtilsException;

public class BrokeragePolicyFactory {

    private static final RentBrokeragePolicy rentBrokeragePolicy = new RentBrokeragePolicy();
    private static final PurchaseBrokeragePolicy purchaseBrokeragePolicy = new PurchaseBrokeragePolicy();

    public static BrokeragePolicy of(ActionType actionType) {
        switch (actionType) {
            case RENT:
                return rentBrokeragePolicy;
            case PURCHASE:
                return purchaseBrokeragePolicy;
            default: // ActionType 추가될 것을 고려
                throw new HouseUtilsException(ErrorCode.INVALID_REQUEST, "해당 actionType에 대한 정책이 존재하지 않습니다.");
        }
    }
}
