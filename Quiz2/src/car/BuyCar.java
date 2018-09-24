package car;

import java.text.DecimalFormat;

public class BuyCar {
	
	//fields
	private double CarCost; // Total price of car (sticker price + taxes + extras)
	private double DownPayment; // Down payment
	private int LoanLength; // Length of loan (in months)
	private double InterestRate; // Interest rate for loan (annually)
	
	//constructors
	public BuyCar() {		
	}
	
	public BuyCar(double cost, double pay, int loan, double interest) {
		this.CarCost = cost;
		this.DownPayment = pay;
		this.LoanLength = loan;
		this.InterestRate = interest / 100;
	}
	
	//methods	
	public double carPayment() { // Monthly car payment
		double monthlyInt = InterestRate / 12;
		double payment = (CarCost - DownPayment) * (monthlyInt * Math.pow(1 + monthlyInt, LoanLength) / (Math.pow(1 + monthlyInt, LoanLength) - 1));
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		return Double.parseDouble(numberFormat.format(payment));
	}
	
	public double totalInterest() { // Total spent on interest over the term of the loan
		double sum = 0;
		double principle = CarCost - DownPayment;
		double monthlyInt = InterestRate / 12;
		
		for (int i = LoanLength; i > 0; i--) {
			sum += principle * monthlyInt;
			principle -= carPayment() - principle * monthlyInt;
		}
		
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		return Double.parseDouble(numberFormat.format(sum));
	}
	
	public static void main(String[] args) {
		BuyCar c = new BuyCar(35000, 0, 60, 10);
		System.out.println(c.carPayment());
		System.out.println(c.totalInterest());
	}
}
