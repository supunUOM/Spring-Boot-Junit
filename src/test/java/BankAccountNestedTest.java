import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @Author: supun
 * @Created: 31/03/2024
 * @Time: 3:43 PM
 **/


public class BankAccountNestedTest {
    @Test
    @DisplayName("Withdraw 500 successfully")
    public void testWithdraw() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfully")
    public void testDeposit() {
        BankAccount bankAccount = new BankAccount(400, 0);
        bankAccount.deposit(600);
        assertEquals(900, bankAccount.getBalance());
    }

    @Nested
    class WhenBalanceEqualsZero {
        @Test
        @DisplayName("withdrawing the min balance: exception")
        public void testWithdrawMinBalanceIs0() {
            BankAccount bankAccount = new BankAccount(0, 0);
            assertThrows(ArithmeticException.class, () -> bankAccount.withdraw(500));

        }

        @Test
        public void testWithdrawMinBalanceNegative1000() {
            BankAccount bankAccount = new BankAccount(0, -1000);
            bankAccount.withdraw(500);
            assertEquals(-500, bankAccount.getBalance());

        }
    }
}
