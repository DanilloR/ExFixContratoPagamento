package models.services;

public interface OnlinePaymentService {
	
	Double Interest (double amount, int months);
	Double PaymentFee(double amount);

}
