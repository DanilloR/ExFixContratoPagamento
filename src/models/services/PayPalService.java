package models.services;

public class PayPalService implements OnlinePaymentService {
	
	public static final Double MonthlyFee = 0.01;
	public static final Double PaymentFee = 0.02;

	@Override
	public Double Interest(double amount, int months) {
		return amount*MonthlyFee*months;
	}

	@Override
	public Double PaymentFee(double amount) {
		return amount*PaymentFee;
	}

}
