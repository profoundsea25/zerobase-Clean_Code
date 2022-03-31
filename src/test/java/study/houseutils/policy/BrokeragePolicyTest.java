package study.houseutils.policy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BrokeragePolicyTest {
    PurchaseBrokeragePolicy purchaseBrokeragePolicy;
    RentBrokeragePolicy rentBrokeragePolicy;

    @BeforeEach
    public void setup() {
        purchaseBrokeragePolicy = new PurchaseBrokeragePolicy();
        rentBrokeragePolicy = new RentBrokeragePolicy();
    }

    @Test
    public void testPurchaseBrokeragePolicy() {
//        //given
//        Long price = 30_000_000L;
//
//        //when
//        Long result = purchaseBrokeragePolicy.calculate(price);
//
//        //then
//        Assertions.assertEquals(result, 180_000L);

        // 케이스가 많으므로 위의 형식에서 아래 형식으로 축약
        Assertions.assertEquals(purchaseBrokeragePolicy.calculate(30_000_000L), 180_000L);
        Assertions.assertEquals(purchaseBrokeragePolicy.calculate(100_000_000L), 500_000L);
        Assertions.assertEquals(purchaseBrokeragePolicy.calculate(500_000_000L), 2_000_000L);
        Assertions.assertEquals(purchaseBrokeragePolicy.calculate(800_000_000L), 4_000_000L);
        Assertions.assertEquals(purchaseBrokeragePolicy.calculate(1_000_000_000L), 9_000_000L);
    }

    @Test
    public void testRentBrokeragePolicy() {
        Assertions.assertEquals(rentBrokeragePolicy.calculate(30_000_000L), 150_000L);
        Assertions.assertEquals(rentBrokeragePolicy.calculate(100_000_000L), 300_000L);
        Assertions.assertEquals(rentBrokeragePolicy.calculate(500_000_000L), 2_000_000L);
        Assertions.assertEquals(rentBrokeragePolicy.calculate(800_000_000L), 6_400_000L);
        Assertions.assertEquals(rentBrokeragePolicy.calculate(1_000_000_000L), 8_000_000L);
    }
}