/**
 * @Author: supun
 * @Created: 31/03/2024
 * @Time: 5:01 PM
 **/

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) //BeforeAll and AfterAll make not be statistic
public class BankAccountBeforeAndAfterTest {
    static BankAccount bankAccount;

    @BeforeAll
    public static void prepTest() {
        System.out.println("Hi!");
        bankAccount = new BankAccount(500,0);
    }


    @BeforeEach
    public void beforeEach(){
        System.out.println("before each..");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("after each..");
    }

    @Test
    public void testWithdraw() {
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance(), "Unexpected Value, Expected 200");
    }

    @Test
    public void testDeposit() {
        bankAccount.deposit(500);
        assertEquals(700, bankAccount.getBalance());
    }

    @AfterAll
    public static void endTest() {
        System.out.println("Bye!");
    }
}
