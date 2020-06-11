package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import models.entities.Contract;
import models.entities.Installment;
import models.services.ContractService;
import models.services.PayPalService;

public class ProgramPgto {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt(); sc.nextLine();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble(); sc.nextLine();
		
		Contract contract =  new Contract(number, date, totalValue);
		
		System.out.print("Enter number of installments: ");
		int installmentsNumber = sc.nextInt();
		
		ContractService contractService = new ContractService(new PayPalService());
		contractService.ProcessContract(contract, installmentsNumber);
		
		System.out.println("Installments:");
		for (Installment i : contract.getInstallments()) {
			System.out.println(i);
		}
		
		sc.close();
	}

}
