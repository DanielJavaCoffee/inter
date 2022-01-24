package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import intidade.CarRental;
import intidade.Venhicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Programa {

	public static void main(String[] args) throws ParseException {


		Scanner leitor = new Scanner(System.in);
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.print("Enter rental data:");
		System.out.println("Car Model:");
		String carModel = leitor.nextLine();
		System.out.println("Picukp (dd/MM/yyyy) HH:ss");
		Date dataInicio = simple.parse(leitor.nextLine());
		System.out.println("Return (dd/MM/yyyy) HH:ss");
		Date dataFim = simple.parse(leitor.nextLine());
		
		CarRental carRental = new CarRental(dataInicio, dataFim, new Venhicle(carModel));

		
		System.out.println("Enter price per hours:");
		double pricePorHours = leitor.nextDouble();
		System.out.println("Enter price per day");
		double pricePorDay = leitor.nextDouble();
		
		RentalService rentalService = new RentalService(pricePorHours, pricePorDay,new BrazilTaxService());
		
		rentalService.carRental(carRental);
		
		System.out.println("Invoice");
		System.out.println("basic payment: " + carRental.getInvoice().getBasicPayment());
		System.out.println("tax: " + carRental.getInvoice().getTax());
		System.out.println("total payment: " + carRental.getInvoice().getTotalPayment());
	}

}
