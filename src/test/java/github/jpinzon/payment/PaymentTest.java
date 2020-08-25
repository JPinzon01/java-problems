package github.jpinzon.payment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PaymentTest {

	@Test
	public void testPaymentStrategies() {
		Assertions.assertEquals(10, PaymentStrategy.pay(5.0, true));
		Assertions.assertEquals(25, PaymentStrategy.pay(10.0, false));
	}
}
