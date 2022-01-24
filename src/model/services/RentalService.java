package model.services;

import intidade.CarRental;
import intidade.Invoice;

public class RentalService {
	
	private double pricePerDay;
	private double pricePerdHour;
	
	private TaxService TaxService;

	public RentalService() {
		
	}
	public RentalService(double pricePerDay, double pricePerdHour, TaxService taxService) {
		this.pricePerDay = pricePerDay;
		this.pricePerdHour = pricePerdHour;
		this.TaxService = TaxService;
	}

	public void carRental(CarRental carRental) {
			
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		
		double hours = (double ) (t2 - t1) / 1000 / 60 / 60; // colocar o tempo em hora
		double basicPayment;
		if(hours <= 12) {
			
			basicPayment = Math.ceil(hours) * pricePerdHour;
		} else {
			basicPayment = Math.ceil(hours / 24) * pricePerDay;
		}
		
		double tax = TaxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
	
	
	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public double getPricePerdHour() {
		return pricePerdHour;
	}

	public void setPricePerdHour(double pricePerdHour) {
		this.pricePerdHour = pricePerdHour;
	}

	public TaxService getBrazilTaxService() {
		return TaxService;
	}

	public void setBrazilTaxService(TaxService TaxService) {
		this.TaxService = TaxService;
	}
}
