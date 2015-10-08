public class CheckingAccount {
	
	private double balance;
	private double totalSrvChrg;
	
	public CheckingAccount(double bal)
	{
		balance = bal;
		totalSrvChrg = 0;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getTotSrvChrg() {
		return totalSrvChrg;
	}
	
	public void setBalance(double bal, int tCode) {
		if (tCode == 1) {
			balance -= bal;
		}
		else if (tCode == 2) {
			balance += bal;
		}
	}
	
	public void setTotSrvChrg(double amt) {
		totalSrvChrg += amt;
	}
}
