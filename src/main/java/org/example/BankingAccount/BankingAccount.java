package org.example.BankingAccount;

public class BankingAccount {
    private String ownerFullName;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankingAccount(String ownerFullName, String accountNumber) {
        this.ownerFullName = ownerFullName;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Amount must be positive.");
        }
    }
    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw successful!");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Only positive amount acceptable.");
        }
    }


    public void displayInfo() {
        System.out.println("Account Holder: " + ownerFullName);
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Balance: %.2f\n", balance);
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

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}