package org.example.banking_account;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankingAccount {
    private String ownerFullName;
    private String accountNumber;
    private double balance;
    private static final Logger logger = LogManager.getLogger("log4jdemo.org.example.BankingAccount");

    // Constructor
    public BankingAccount(String ownerFullName, String accountNumber) {
        this.ownerFullName = ownerFullName;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            logger.info("Deposit successful!");
        } else {
            logger.info("Amount must be positive.");
        }
    }
    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            logger.info("Withdraw successful!");
        } else if (amount > balance) {
            logger.info("Insufficient funds.");
        } else {
            logger.info("Only positive amount acceptable.");
        }
    }


    public void displayInfo() {
        logger.info("Account Holder: {}", ownerFullName);
        logger.info("Account Number: {}", accountNumber);
        logger.info("Balance: %.2f\n", balance);
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }

    public void setOwnerFullName(String ownerFullName) {
        this.ownerFullName = ownerFullName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

}