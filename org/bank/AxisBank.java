package org.bank;

public class AxisBank extends BankInfo{
	
	public void deposit() {
		System.out.println("deposit in AxisBank");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		AxisBank ab=new AxisBank();
		ab.saving();
		ab.fixed();
		
		System.out.println("-----Deposit method overridden------");
		ab.deposit();
	}

}
