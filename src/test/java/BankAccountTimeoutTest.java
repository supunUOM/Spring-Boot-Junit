import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

/**
 * @Author: supun
 * @Created: 31/03/2024
 * @Time: 4:48 PM
 **/

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeoutTest {
    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    public void testDepositTimeoutAssertion(BankAccount bankAccount) {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        bankAccount.deposit(400);
        assertEquals(400, bankAccount.getBalance());
    }

    @Test
    public void testDepositTimeoutAnnotation(BankAccount bankAccount) {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        bankAccount.deposit(400);
        assertTimeout(Duration.ofMillis(500), () -> {
            Thread.sleep(10);
            bankAccount.getBalance();
        });
    }
}
