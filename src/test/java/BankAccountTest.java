import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @Author: supun
 * @Created: 31/03/2024
 * @Time: 12:21 PM
 **/

@DisplayName("BankAccount Tests")
public class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    public void initTest() {
        bankAccount = new BankAccount(0, -1000);
    }

    @Test
    @DisplayName("Deposit 100")
    public void testAdding() {
        assertEquals(200, bankAccount.deposit(200));
    }

    @Test
    @DisplayName("withdraw 100")
    public void testDivide() {
        assertEquals(100, bankAccount.withdraw(100));
    }

    @Test
    @DisplayName("withdraw 10_000")
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> bankAccount.withdraw(10000));
    }

    @Test
    public void isActiveAccount() {
        assertEquals(true, bankAccount.isActive());
    }

    @Test
    public void testHolderName() {
        BankAccount bankAccount = new BankAccount(0, 100);
        bankAccount.setHolderName("Supun");
        assertEquals("Supun", bankAccount.getHolderName());
        assertNotNull(bankAccount.getHolderName());
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(1000));
    }

    @Test
    public void assertValidate() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertAll(() -> bankAccount.deposit(200), () -> bankAccount.withdraw(4550));
    }

    @Test
    @DisplayName("deposit Time test")
    public void testDepositTimeOut() {
        BankAccount bankAccount = new BankAccount(400, 0);
        assertTimeout(Duration.ofNanos(1), () -> bankAccount.deposit(3000));
    }

    @Test
    public void failMethodTest() {
        fail();
    }

}
