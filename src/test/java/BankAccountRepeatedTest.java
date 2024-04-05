import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: supun
 * @Created: 31/03/2024
 * @Time: 4:10 PM
 **/

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatedTest {
    @RepeatedTest(4)
    @DisplayName("Deposit 400 successfully.")
    public void testDeposit(BankAccount bankAccount) {
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }
}
