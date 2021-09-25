package AP_Task2;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountTest {
	Expert Answer
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	private static boolean setUpIsDone = false;
	private static Account account=null;
	@Before
	public void setUp() {
		if (setUpIsDone) {
			return;
		}
		// do the setup
		account=new Account();
		setUpIsDone = true;
	}
	@Test
	public void testDepositMoney() {
		account.deposit(500);
		assertEquals(500, account.getBalance());
		assertEquals(true, account.getTransactions().contains("Deposit 500 to the account"));
	}
	@Test
	public void testInsufficientWithdrawAmount() {
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("Insufficient balance");
		account.withdraw(10000);
	}
	@Test
	public void testNegativeDepositAmount() {
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("Negative amount");
		account.deposit(-1);
	}
	@Test
	public void testNegativeWithdrawAmount() {
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("Negative amount");
		account.withdraw(-1);
	}
	@Test
	public void testWithdrawMoney() {
		account.withdraw(500);
		assertEquals(0, account.getBalance());
		assertEquals(true, account.getTransactions().contains("Withdraw 500 to the account"));
	}
}