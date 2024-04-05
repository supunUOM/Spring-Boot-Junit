import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/**
 * @Author: supun
 * @Created: 31/03/2024
 * @Time: 3:28 PM
 **/

public class BankAccountTestAssumptions {
    @Test
    public void testActive() {
        BankAccount bankAccount = new BankAccount(500, 0);
        assumeFalse(bankAccount == null, "bankAccount is Not null.");
        System.out.println("assumption is true...");
        assertTrue(bankAccount.isActive());
    }

    @Test
    public void assumeThat() {
        BankAccount bankAccount = new BankAccount(200, 100);
        assumingThat(bankAccount != null, () -> assertTrue(bankAccount.isActive()));
    }

}
