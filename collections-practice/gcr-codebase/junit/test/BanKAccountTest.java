package junit.example;

import org.junit.jupiter.api.Test;
import src.main.java.org.example.BankAccount;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testDepositIncreasesBalance() {
        BankAccount account = new BankAccount();
        account.deposit(500);

        assertEquals(500, account.getBalance());
    }

    @Test
    void testWithdrawReducesBalance() {
        BankAccount account = new BankAccount();
        account.deposit(500);
        account.withdraw(200);

        assertEquals(300, account.getBalance());
    }

    @Test
    void testWithdrawFailsWhenInsufficientFunds() {
        BankAccount account = new BankAccount();
        account.deposit(100);

        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(200));
    }
}