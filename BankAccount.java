import javax.swing.JOptionPane;

public class BankAccount {
	
	final static double WITHDRAW_CHARGE = 0.15;
	final static double DEPOSIT_CHARGE = 0.10;

	public static void main(String[] args) {
		String initBalance;
		int transCode;
		double transAmt;
		
		//Ask user for initial balance
		initBalance = JOptionPane.showInputDialog("Enter initial amount:");
		
		//Create CheckingAccount object with initial balance
		CheckingAccount accountOne = new CheckingAccount(
				Double.parseDouble(initBalance));
		
		//process transaction code
		transCode = getTransCode();
		switch(transCode) {
		//exit
		case 0:
			exitMessage(accountOne);
			break;
		//withdraw
		case 1:
			transAmt = getTransAmt();
			processWithdraw(accountOne,transAmt,transCode);
			displayMessage(accountOne,"Withdraw", transAmt);
			break;
		//deposit
		case 2:
			transAmt = getTransAmt();
			displayMessage(accountOne,"Deposit", transAmt);
			break;
		}
		
	}
	
	public static int getTransCode() {
		String transCode;
		int tCode;
		do {
			transCode = JOptionPane.showInputDialog("Enter transaction code:");
			tCode = Integer.parseInt(transCode);
			if(tCode != 1 && tCode != 2 && tCode != 0) {
				JOptionPane.showMessageDialog(null, "Invalid transaction "
						+ "code.");
			}
		}while(tCode != 1 && tCode != 2 && tCode != 0);
		return tCode;
	}
	
	public static double getTransAmt() {
		String transAmt;
		transAmt = JOptionPane.showInputDialog("Enter transaction amount:");
		return Double.parseDouble(transAmt);
	}
	
	public static void processWithdraw(CheckingAccount acct, double amt, int tCode) {
		acct.setBalance(amt,tCode);
		acct.setTotSrvChrg(WITHDRAW_CHARGE);
	}
	
	public static void processDeposit(CheckingAccount acct, double amt, int tCode) {
		acct.setBalance(amt,tCode);
		acct.setTotSrvChrg(DEPOSIT_CHARGE);
	}

	public static void exitMessage(CheckingAccount acct) {
		String message;
		double currentBalance = acct.getBalance();
		double totalServiceCharge = acct.getTotSrvChrg();
		double finalBalance = currentBalance - totalServiceCharge;
		message = "Transaction: End\nCurrent Balance: " + currentBalance
					+ "\nTotal Service Charge: " + totalServiceCharge +
					"\nFinal Balance: " + finalBalance;
		JOptionPane.showMessageDialog(null, message);
	}
	
	public static void displayMessage(CheckingAccount acct, String trans, double amt) {
		String message;
		double currentBalance = acct.getBalance();
		double totalServiceCharge = acct.getTotSrvChrg();
		message = "Transaction: " + trans + " in amount of " + amt
					+ "\nCurrent Balance: " + currentBalance
					+ "\nTotal Service Charge: " + totalServiceCharge;
		JOptionPane.showMessageDialog(null, message);
	}
}
