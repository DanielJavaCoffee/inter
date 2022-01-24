package intidade;

import java.util.Date;

public class CarRental {
	
	private Date start;
	private Date finish;
	
	private Venhicle venhicle;
	private Invoice invoice;
	
	public CarRental() {
		
	}

	public CarRental(Date start, Date finish, Venhicle venhicle) {
		this.start = start;
		this.finish = finish;
		this.venhicle = venhicle;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public Venhicle getVenhicle() {
		return venhicle;
	}

	public void setVenhicle(Venhicle venhicle) {
		this.venhicle = venhicle;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}
