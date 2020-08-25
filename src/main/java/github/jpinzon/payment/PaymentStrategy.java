package github.jpinzon.payment;

public interface PaymentStrategy {
	// write here your solution

	static double pay(double amount, boolean isCash) {
		if (isCash) {
			return new CashPaymentStrategy().pay(amount);
		} else {
			return new CreditCardStrategy().pay(amount);
		}
	}
}
