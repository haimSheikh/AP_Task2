/**
 * 
 */
package AP_Task2;
import java.util.ArrayList;
/**
 * @author Muhammad Haim
 *
 */
public class Account {

	private int balance=0;
	private ArrayList<String> transactions;
	public Account() {
		this.balance=0;
		this.transactions=new ArrayList<String>();	}
	public int getBalance() {
		return balance;
	}
	/**
	 * @return the transactions
	 */
	public ArrayList<String> getTransactions() {
		return transactions;
	}
	public void deposit(int money) {
		if(money<0) {
			throw new IllegalArgumentException("Negative amount");
		}
		this.balance+=money;
		this.transactions.add("Deposit "+money+" to the account");
	}
	public void withdraw(int money) {
		if(money<0) {
			throw new IllegalArgumentException("Negative amount");
		}
		if(money>balance) {
			throw new IllegalArgumentException("Insufficient balance");
		}
		this.balance-=money;
		this.transactions.add("Withdraw "+money+" to the account");
	}
}
