package models.services;

import java.util.Calendar;
import java.util.Date;

import models.entities.Contract;
import models.entities.Installment;


public class ContractService {	
	
	private OnlinePaymentService onlinePaymentService;
	
	
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	private Date addDate(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH,n);
		return cal.getTime();
	}
	
	public void ProcessContract(Contract contract, int months) {
		double grossValue = contract.getTotalValue()/months;
		for (int i=1; i<=months;i++) {
			Date processDueDate = addDate(contract.getDate(),i);
			double updateInstallment = grossValue + (onlinePaymentService.Interest(grossValue, i));
			double finalValue = updateInstallment+onlinePaymentService.PaymentFee(updateInstallment);
			contract.addInstallment(new Installment(processDueDate, finalValue));
		}
	}

}
