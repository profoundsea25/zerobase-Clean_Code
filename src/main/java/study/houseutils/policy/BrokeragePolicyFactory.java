package study.houseutils.policy;

import study.houseutils.constant.ActionType;
import study.houseutils.exception.ErrorCode;
import study.houseutils.exception.HouseUtilsException;

public class BrokeragePolicyFactory {

    public static BrokeragePolicy of(ActionType actionType) {
        switch (actionType) {
            case RENT:
                return new RentBrokeragePolicy();
            case PURCHASE:
                return new PurchaseBrokeragePolicy();
            default: // ActionType 추가될 것을 고려
                throw new HouseUtilsException(ErrorCode.INVALID_REQUEST, "해당 actionType에 대한 정책이 존재하지 않습니다.");
        }
    }
}
