package org.example.banking_account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankingAccountTest {

    @Test
    void depositShouldIncreaseBalance() {
        BankingAccount acc = new BankingAccount("Mateusz", "PL123");

        acc.deposit(100);

        assertEquals(100, acc.getBalance());
    }
    @Test
    void withdrawShouldDecreaseBalance()
    {
        BankingAccount acc = new BankingAccount("Mateusz", "PL123");
        acc.deposit(100.0);

        acc.withdraw(100.0);
        assertEquals(0,acc.getBalance());
    }
}
