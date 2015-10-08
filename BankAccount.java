import javax.swing.JOptionPane;

public class BankAccount {

	public static void main(String[] args) {
		String initBalance, transCode;
		
		//Ask user for initial balance
		initBalance = JOptionPane.showInputDialog("Enter initial amount:");
		
		//Create CheckingAccount object with initial balance
		CheckingAccount accountOne = new CheckingAccount(
				Double.parseDouble(initBalance));
		
		//process transaction code
		processTransCode(accountOne);
		
	}
	
	public static void processTransCode(CheckingAccount acct) {
		String tranAmt, transCode;
		int tCode;
		do {
			transCode = JOptionPane.showInputDialog("Enter transaction code:");
			tCode = Integer.parseInt(transCode);
			if(tCode == 1 || tCode == 2) {
				tranAmt = JOptionPane.showInputDialog("Enter transaction amount:");
				double bal = Double.parseDouble(tranAmt);
				acct.setBalance(bal, tCode);
			} else if (tCode == 0) {
				exitMessage(acct);
			} else {
				JOptionPane.showMessageDialog(null, "Invalid transaction "
						+ "code.");
			}
		}while(tCode != 1 && tCode != 2 && tCode != 0);
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
}
